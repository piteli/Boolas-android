package com.rush.wender.boolas;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class dk extends AppCompatActivity {

    Toolbar toolbar;
    private ListView listView;
    private JSONArray result;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arrayList;
    private HashMap<String, String> hashMap;
    private String hantar;
    private String hantar2;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dk);

      //  getData();

        hashMap = new HashMap<String, String>();

        hashMap.put("DK1","DKK1FSK");
        hashMap.put("DK2","DKK2FSK");
        hashMap.put("DK3","DKK3FSK");
        hashMap.put("DK4","DKK4FSK");
        hashMap.put("DK5","DKK5FSK");
        hashMap.put("DK6","DKK6FSK");
        hashMap.put("DK7","DKK7FSK");
        hashMap.put("DK8","DKK8FSK");
        hashMap.put("DK9","DKK9FSK");
        hashMap.put("DK10","DKK10FSK");

        arrayList = new ArrayList<String>();
        arrayList.add("DK1");
        arrayList.add("DK2");
        arrayList.add("DK3");
        arrayList.add("DK4");
        arrayList.add("DK5");
        arrayList.add("DK6");
        arrayList.add("DK7");
        arrayList.add("DK8");
        arrayList.add("DK9");
        arrayList.add("DK10");

        listView = (ListView) findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(dk.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String hantar = (String)listView.getItemAtPosition(position);
                hantar2 = hashMap.get(hantar);
                Log.e("sat",hantar2);

                intent = new Intent(dk.this,table.class);
                intent.putExtra("hantar2",hantar2);
                dk.this.startActivity(intent);

        }
    });

      //  listView = (ListView)findViewById(R.id.listView);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Choose Hall");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    /*

    public void getData(){

        StringRequest stringRequest = new StringRequest(QueryDK.DATA_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject j = null;

                try {
                    j = new JSONObject(response);

                    result = j.getJSONArray(QueryDK.JSON_ARRAY);
                    getList(result);
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
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void getList(JSONArray j){

        hashMap = new HashMap<String, String>();
        arrayList = new ArrayList<String>();

        for(int i=0; i<j.length(); i++){
            try{
                JSONObject jsonObject = j.getJSONObject(i);
                hashMap.put(jsonObject.getString(QueryDK.FSK_NAME),jsonObject.getString(QueryDK.FSK_CODE));
                arrayList.add(jsonObject.getString(QueryDK.FSK_NAME));
            }catch(JSONException e){
                e.printStackTrace();
            }
        }

        arrayAdapter = new ArrayAdapter<String>(dk.this, android.R.layout.simple_list_item_1, arrayList);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);


    }

    */
}
