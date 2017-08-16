package com.rush.wender.boolas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
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
    private ArrayList<String> main_isarraylist;
    private ArrayList<String> isarraylist;
    private ArrayList<String> arrayList;
    private HashMap<String, String> hashMap;
    private String hantar;
    private String hantar2;
    private Intent intent;
    private ProgressBar progressBar;
    private Context context;
    private String[] args = {"dummy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dk);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        AlertDialog alertDialog = new AlertDialog.Builder(dk.this).create();
        DownloadTask task = new DownloadTask();
        DownloadTask2 task2 = new DownloadTask2();
        main_isarraylist = new ArrayList<String>();
        isarraylist = new ArrayList<String>();
        String result = null;
        String main_result = null;
        String main_get;
        String get;
        arrayList = null;
        hashMap = null;
        context = this;
        CheckWifiConnection wifiConnection = new CheckWifiConnection();
        CheckDataConnection dataConnection = new CheckDataConnection();
        Boolean getWifiConnection = wifiConnection.isWifi(context);
        Boolean getDataConnection = dataConnection.isOline(context);


        if(getWifiConnection == true || getDataConnection == true) {
            try {

                main_result = task2.execute("http://icress.uitm.edu.my/jadual/hs/hs.html").get();
                main_get = main_result.replaceAll("\\s+", "");

                Pattern main_p = Pattern.compile("target=\"dua\">(.*?)</a>");
                Matcher main_m = main_p.matcher(main_get);

                int t = 0;
                while (main_m.find()) {
                    args[t] = "http://icress.uitm.edu.my/jadual/HS/"+main_m.group(1)+".html";
                    System.out.println(args[t]);
                    t++;
                }





                if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ) {
                    result = task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, args).get();
                    get = result.replaceAll("\\s+", "");

                    Pattern p = Pattern.compile("<TD>(.*?)</TD>");
                    Matcher m = p.matcher(get);

                    while (m.find()) {
                        isarraylist.add(m.group(1));
                        System.out.println(m.group(1));
                    }
                } else {
                    result = task.execute(args).get();
                    get = result.replaceAll("\\s+", "");

                    Pattern p = Pattern.compile("<TD>(.*?)</TD>");
                    Matcher m = p.matcher(get);

                    while (m.find()) {
                        isarraylist.add(m.group(1));
                        System.out.println(m.group(1));
                    }
                }


                arrayList = new ArrayList<String>();
                hashMap = new HashMap<String, String>();


                for (int i = 0; i <= isarraylist.size(); i++) {
                    if (isarraylist.contains("DKK" + i + "FSK")) {
                        arrayList.add("Dewan Kuliah " + i);
                        hashMap.put("Dewan Kuliah " + i, "DKK" + i + "FSK");
                    }
                }


            } catch (InterruptedException e) {
                alertDialog.setTitle("Error Downloading");
                alertDialog.setMessage("Oops, seems like targeted scrapped web has been changed");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                progressBar.setVisibility(View.INVISIBLE);

                e.printStackTrace();
            } catch (ExecutionException e) {
                alertDialog.setTitle("Error Downloading");
                alertDialog.setMessage("Oops, seems like targeted scrapped web has been changed");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                progressBar.setVisibility(View.INVISIBLE);
                e.printStackTrace();
            }


            //  getData();
            listView = (ListView) findViewById(R.id.listView);

            arrayAdapter = new ArrayAdapter<String>(dk.this, android.R.layout.simple_list_item_1, arrayList);
            listView.setAdapter(arrayAdapter);
            progressBar.setVisibility(View.INVISIBLE);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String hantar = (String) listView.getItemAtPosition(position);
                    hantar2 = hashMap.get(hantar);
                    Log.e("sat", hantar2);

                    intent = new Intent(dk.this, table.class);
                    intent.putExtra("hantar2", hantar2);
                    dk.this.startActivity(intent);

                }
            });

        }
        else {
            alertDialog.setTitle("Error Network");
            alertDialog.setMessage("No network connection");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "try again",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            recreate();
                        }
                    });
            alertDialog.show();
            System.out.println("No network connection");
        }



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
                for (int p = 0; p < args.length; p++) {
                    url = new URL(urls[p]);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader reader = new InputStreamReader(in);
                    int data = reader.read();

                    while (data != -1) {
                        char current = (char) data;
                        result += current;
                        data = reader.read();
                    }
                }

                return result;

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }



    public class DownloadTask2 extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try{
                    url = new URL(urls[0]);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader reader = new InputStreamReader(in);
                    int data = reader.read();

                    while (data != -1) {
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
