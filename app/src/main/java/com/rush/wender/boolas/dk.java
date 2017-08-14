package com.rush.wender.boolas;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dk extends AppCompatActivity {

    Toolbar toolbar;
    private ListView listView;
    private JSONArray result;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> isarraylist;
    private ArrayList<String> arrayList;
    private HashMap<String, String> hashMap;
    private String hantar;
    private String hantar2;
    private Intent intent;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dk);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        DownloadTask task = new DownloadTask();
        isarraylist = new ArrayList<String>();
        String result = null;
        String get;
        try {
            result = task.execute("http://icress.uitm.edu.my/jadual/HS/UED102.html").get();
            get = result.replaceAll("\\s+","");

            Pattern p = Pattern.compile("<TD>(.*?)</TD>");
            Matcher m = p.matcher(get);

            while(m.find()){
                isarraylist.add(m.group(1));
                System.out.println(m.group(1));
            }

            isarraylist.remove(0);
            isarraylist.remove(1);
            isarraylist.remove(2);
            isarraylist.remove(3);
            isarraylist.remove(4);
            isarraylist.remove(5);
            isarraylist.remove(6);


        } catch (InterruptedException e) {
            progressBar.setVisibility(View.INVISIBLE);
            e.printStackTrace();
        } catch (ExecutionException e) {
            progressBar.setVisibility(View.INVISIBLE);
            e.printStackTrace();
        }


        //  getData();

        arrayList = new ArrayList<String>();
        hashMap = new HashMap<String, String>();


        for(int i = 0; i<=isarraylist.size();i++){
            if(isarraylist.contains("DKK"+i+"FSK")){
                arrayList.add("Dewan Kuliah "+i);
                hashMap.put("Dewan Kuliah "+i, "DKK"+i+"FSK");
            }
        }

        listView = (ListView) findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(dk.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        progressBar.setVisibility(View.INVISIBLE);

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

        getSupportActionBar().setTitle("Choose available Hall");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public class DownloadTask extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try{
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection)url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader  = new InputStreamReader(in);
                int data = reader.read();

                while(data != -1){
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                return result;

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
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
