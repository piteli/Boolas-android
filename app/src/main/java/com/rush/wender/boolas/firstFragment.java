package com.rush.wender.boolas;


import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.rush.wender.boolas.R.id.listView;


/**
 * A simple {@link Fragment} subclass.
 */
public class firstFragment extends Fragment {

    ArrayList<CardSecond> arrayList;
    ListView listView;
    Boolean checkJSON = false;
    ArrayList<String> arrayList1;


    public firstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        listView = (ListView)view.findViewById(R.id.listView);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView2);
        TextView textView = (TextView)view.findViewById(R.id.textView3);

        getData();

        if(checkJSON == true){
            listView.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
        }

        return view;


    }

    public void getData(){

        StringRequest stringRequest = new StringRequest(QueryApp.DATA_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject j = null;
                JSONArray result;

                try {
                    j = new JSONObject(response);

                    result = j.getJSONArray(QueryApp.JSON_ARRAY);
                    getList(result);

                    if(result != null){
                        checkJSON = true;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

    }

    public void getList(JSONArray j){

        arrayList = new ArrayList<>();

        for(int i=0; i<j.length(); i++){
            try{
                JSONObject jsonObject = j.getJSONObject(i);
                arrayList.add(new CardSecond("drawable://" + R.drawable.fsk7 ,jsonObject.getString(QueryApp.APP_NAME),
                        jsonObject.getString(QueryApp.APP_FROM), jsonObject.getString(QueryApp.APP_TO),
                        jsonObject.getString(QueryApp.APP_DESC)));

            }catch(JSONException e){
                e.printStackTrace();
                System.out.println("failed");

            }
        }

        CustomlistAdapterSecond adapter = new CustomlistAdapterSecond(getActivity(), R.layout.card_second, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });


    }

}
