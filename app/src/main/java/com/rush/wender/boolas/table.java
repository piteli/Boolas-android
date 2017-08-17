package com.rush.wender.boolas;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class table extends AppCompatActivity {

    Spinner droDay;
    private JSONArray result;
    private HashMap<String, String> hashMap;
    private ArrayList<String> api_course;
    private ArrayList<String> api_group;
    private ArrayList<String> api_start;
    private ArrayList<String> api_end;
    private ArrayList<String> api_day;
    private ArrayList<String> api_room;
    private ArrayList<String> collectDay;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayAdapter<String> arrayAdapter2;
    private HashMap<String, String> isnin;
    private HashMap<String, String> selasa;
    private HashMap<String, String> rabu;
    private HashMap<String, String> khamis;
    private HashMap<String, String> jumaat;
    private ArrayList<String> amikIsnin;
    private ArrayList<String> amikSelasa;
    private ArrayList<String> amikRabu;
    private ArrayList<String> amikKhamis;
    private ArrayList<String> amikJumaat;
    private Spinner spinner2;
    private Button hantar;
    private EditText name;
    private EditText desc;
    private ProgressDialog progressDialog;
    private ProgressDialog progressDialog2;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Pick your time table");

        Intent intent = getIntent();
        String hantar2 = intent.getStringExtra("hantar2");

        isnin = new HashMap <String, String>();
        selasa = new HashMap<String, String>();
        rabu = new HashMap<String, String>();
        khamis = new HashMap<String, String>();
        jumaat = new HashMap<String, String>();

        isnin.put("dt1","Monday , 8.30am");
        isnin.put("dt2","Monday , 8.30am");
        isnin.put("dt3","Monday, 9.30am");
        isnin.put("dt4","Monday, 9.30am");
        isnin.put("dt5","Monday, 10.30am");
        isnin.put("dt6","Monday, 10.30am");
        isnin.put("dt7","Monday, 11.30am");
        isnin.put("dt8","Monday, 11.30am");
        isnin.put("dt9","Monday, 12.30pm");
        isnin.put("dt10","Monday, 12.30pm");
        isnin.put("dt11","Monday, 1.30pm");
        isnin.put("dt12","Monday, 1.30pm");
        isnin.put("dt13","Monday, 2.30pm");
        isnin.put("dt14","Monday, 2.30pm");
        isnin.put("dt15","Monday, 3.30pm");
        isnin.put("dt16","Monday, 3.30pm");
        isnin.put("dt17","Monday, 4.30pm");
        isnin.put("dt18","Monday, 4.30pm");
        isnin.put("dt19","Monday, 5.30pm");
        isnin.put("dt20","Monday, 5.30pm");
        isnin.put("dt21","Monday, 6.30pm");
        isnin.put("dt22","Monday, 6.30pm");



        selasa.put("dt23","Tuesday, 8.30am");
        selasa.put("dt24","Tuesday, 8.30am");
        selasa.put("dt25","Tuesday, 9.30am");
        selasa.put("dt26","Tuesday, 9.30am");
        selasa.put("dt27","Tuesday, 10.30am");
        selasa.put("dt28","Tuesday, 10.30am");
        selasa.put("dt29","Tuesday, 11.30am");
        selasa.put("dt30","Tuesday, 11.30am");
        selasa.put("dt31","Tuesday, 12.30pm");
        selasa.put("dt32","Tuesday, 12.30pm");
        selasa.put("dt33","Tuesday, 1.30pm");
        selasa.put("dt34","Tuesday, 1.30pm");
        selasa.put("dt35","Tuesday, 2.30pm");
        selasa.put("dt36","Tuesday, 2.30pm");
        selasa.put("dt37","Tuesday, 3.30pm");
        selasa.put("dt38","Tuesday, 3.30pm");
        selasa.put("dt39","Tuesday, 4.30pm");
        selasa.put("dt40","Tuesday, 4.30pm");
        selasa.put("dt41","Tuesday, 5.30pm");
        selasa.put("dt42","Tuesday, 5.30pm");
        selasa.put("dt43","Tuesday, 6.30pm");
        selasa.put("dt44","Tuesday, 6.30pm");

        rabu.put("dt45","Wednesday , 8.30am");
        rabu.put("dt46","Wednesday , 8.30am");
        rabu.put("dt47","Wednesday, 9.30am");
        rabu.put("dt48","Wednesday, 9.30am");
        rabu.put("dt49","Wednesday, 10.30am");
        rabu.put("dt50","Wednesday, 10.30am");
        rabu.put("dt51","Wednesday, 11.30am");
        rabu.put("dt52","Wednesday, 11.30am");
        rabu.put("dt53","Wednesday, 12.30pm");
        rabu.put("dt54","Wednesday, 12.30pm");
        rabu.put("dt55","Wednesday, 1.30pm");
        rabu.put("dt56","Wednesday, 1.30pm");
        rabu.put("dt57","Wednesday, 2.30pm");
        rabu.put("dt58","Wednesday, 2.30pm");
        rabu.put("dt59","Wednesday, 3.30pm");
        rabu.put("dt60","Wednesday, 3.30pm");
        rabu.put("dt61","Wednesday, 4.30pm");
        rabu.put("dt62","Wednesday, 4.30pm");
        rabu.put("dt63","Wednesday, 5.30pm");
        rabu.put("dt64","Wednesday, 5.30pm");
        rabu.put("dt65","Wednesday, 6.30pm");
        rabu.put("dt66","Wednesday, 6.30pm");

        khamis.put("dt67","Thursday, 8.30am");
        khamis.put("dt68","Thursday, 8.30am");
        khamis.put("dt69","Thursday, 9.30am");
        khamis.put("dt70","Thursday, 9.30am");
        khamis.put("dt71","Thursday, 10.30am");
        khamis.put("dt72","Thursday, 10.30am");
        khamis.put("dt73","Thursday, 11.30am");
        khamis.put("dt74","Thursday, 11.30am");
        khamis.put("dt75","Thursday, 12.30pm");
        khamis.put("dt76","Thursday, 12.30pm");
        khamis.put("dt77","Thursday, 1.30pm");
        khamis.put("dt78","Thursday, 1.30pm");
        khamis.put("dt79","Thursday, 2.30pm");
        khamis.put("dt80","Thursday, 2.30pm");
        khamis.put("dt81","Thursday, 3.30pm");
        khamis.put("dt82","Thursday, 3.30pm");
        khamis.put("dt83","Thursday, 4.30pm");
        khamis.put("dt84","Thursday, 4.30pm");
        khamis.put("dt85","Thursday, 5.30pm");
        khamis.put("dt86","Thursday, 5.30pm");
        khamis.put("dt87","Thursday, 6.30pm");
        khamis.put("dt88","Thursday, 6.30pm");

        jumaat.put("dt89","Friday, 8.30am");
        jumaat.put("dt90","Friday, 8.30am");
        jumaat.put("dt91","Friday, 9.30am");
        jumaat.put("dt92","Friday, 9.30am");
        jumaat.put("dt93","Friday, 10.30am");
        jumaat.put("dt94","Friday, 10.30am");
        jumaat.put("dt95","Friday, 11.30am");
        jumaat.put("dt96","Friday, 11.30am");
        jumaat.put("dt97","Friday, 12.30pm");
        jumaat.put("dt98","Friday, 12.30pm");
        jumaat.put("dt99","Friday, 1.30pm");
        jumaat.put("dt100","Friday, 1.30pm");
        jumaat.put("dt101","Friday, 2.30pm");
        jumaat.put("dt102","Friday, 2.30pm");
        jumaat.put("dt103","Friday, 3.30pm");
        jumaat.put("dt104","Friday, 3.30pm");
        jumaat.put("dt105","Friday, 4.30pm");
        jumaat.put("dt106","Friday, 4.30pm");
        jumaat.put("dt107","Friday, 5.30pm");
        jumaat.put("dt108","Friday, 5.30pm");
        jumaat.put("dt109","Friday, 6.30pm");
        jumaat.put("dt110","Friday, 6.30pm");

     //   isnin.put("dt1","")

        getData(hantar2);

        droDay = (Spinner) findViewById(R.id.droDay);

        droDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String finDay = droDay.getSelectedItem().toString();

                if(isnin.containsValue(finDay)){
                    amikIsnin = new ArrayList<String>();
                    for (int i = 1; i < 23; i+=2) {
                        String wee = "dt"+i;
                        int id2  = getResources().getIdentifier(wee, "id", getPackageName());
                        if (id2 != 0 && i != 1) {
                            TextView textView = (TextView) findViewById(id2);
                            String haha = textView.getText().toString();

                            if(haha != "     N/A     "){


                                String day = hashMap.get(wee);
                                amikIsnin.add(day);

                                    if(amikIsnin.contains(finDay)){

                                        for(int w = amikIsnin.indexOf(finDay);w >= 0; --w){

                                            amikIsnin.remove(w);

                                        }
                                    }
                            }

                        }

                    }
                    spinner2 = (Spinner)findViewById(R.id.spinner2);
                    arrayAdapter2 = new ArrayAdapter<String>(table.this, android.R.layout.simple_spinner_dropdown_item, amikIsnin);

                    arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(arrayAdapter2);


                }

                else if(selasa.containsValue(finDay)){

                    amikSelasa = new ArrayList<String>();
                    for (int i = 23; i < 45; i+=2) {
                        String wee = "dt"+i;
                        int id2  = getResources().getIdentifier(wee, "id", getPackageName());
                        if (id2 != 0 && i != 23) {
                            TextView textView = (TextView) findViewById(id2);
                            String haha = textView.getText().toString();

                            if(haha != "     N/A     "){


                                String day = hashMap.get(wee);
                                amikSelasa.add(day);
                                if(amikSelasa.contains(finDay)){

                                    for(int w = amikSelasa.indexOf(finDay);w >= 0; --w){

                                        amikSelasa.remove(w);

                                    }
                                }
                            }

                        }

                    }
                    spinner2 = (Spinner)findViewById(R.id.spinner2);
                    arrayAdapter2 = new ArrayAdapter<String>(table.this, android.R.layout.simple_spinner_dropdown_item, amikSelasa);

                    arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(arrayAdapter2);

                }

                else if(rabu.containsValue(finDay)){

                    amikRabu = new ArrayList<String>();
                    for (int i = 45; i < 67; i+=2) {
                        String wee = "dt"+i;
                        int id2  = getResources().getIdentifier(wee, "id", getPackageName());
                        if (id2 != 0 && i != 45) {
                            TextView textView = (TextView) findViewById(id2);
                            String haha = textView.getText().toString();

                            if(haha != "     N/A     "){


                                String day = hashMap.get(wee);
                                amikRabu.add(day);
                                if(amikRabu.contains(finDay)){

                                    for(int w = amikRabu.indexOf(finDay);w >= 0; --w){

                                        amikRabu.remove(w);

                                    }
                                }
                            }

                        }

                    }
                    spinner2 = (Spinner)findViewById(R.id.spinner2);
                    arrayAdapter2 = new ArrayAdapter<String>(table.this, android.R.layout.simple_spinner_dropdown_item, amikRabu);

                    arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(arrayAdapter2);

                }

                else if(khamis.containsValue(finDay)){

                    amikKhamis = new ArrayList<String>();
                    for (int i = 67; i < 89; i+=2) {
                        String wee = "dt"+i;
                        int id2  = getResources().getIdentifier(wee, "id", getPackageName());
                        if (id2 != 0 && i != 67) {
                            TextView textView = (TextView) findViewById(id2);
                            String haha = textView.getText().toString();

                            if(haha != "     N/A     "){


                                String day = hashMap.get(wee);
                                amikKhamis.add(day);
                                if(amikKhamis.contains(finDay)){

                                    for(int w = amikKhamis.indexOf(finDay);w >= 0; --w){

                                        amikKhamis.remove(w);

                                    }
                                }
                            }

                        }

                    }
                    spinner2 = (Spinner)findViewById(R.id.spinner2);
                    arrayAdapter2 = new ArrayAdapter<String>(table.this, android.R.layout.simple_spinner_dropdown_item, amikKhamis);

                    arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(arrayAdapter2);

                }

                else if(jumaat.containsValue(finDay)){

                    amikJumaat = new ArrayList<String>();
                    for (int i = 89; i < 111; i+=2) {
                        String wee = "dt"+i;
                        int id2  = getResources().getIdentifier(wee, "id", getPackageName());
                        if (id2 != 0 && i != 89) {
                            TextView textView = (TextView) findViewById(id2);
                            String haha = textView.getText().toString();

                            if(haha != "     N/A     "){


                                String day = hashMap.get(wee);
                                amikJumaat.add(day);
                                if(amikJumaat.contains(finDay)){

                                    for(int w = amikJumaat.indexOf(finDay);w >= 0; --w){

                                        amikJumaat.remove(w);

                                    }
                                }
                            }

                        }

                    }
                    spinner2 = (Spinner)findViewById(R.id.spinner2);
                    arrayAdapter2 = new ArrayAdapter<String>(table.this, android.R.layout.simple_spinner_dropdown_item, amikJumaat);

                    arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(arrayAdapter2);

                }

                else{}


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        hantar = (Button)findViewById(R.id.HantarTab);

        hantar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog2 = ProgressDialog.show(table.this,"Loading...",
                        "Submitting data, please wait...", false, false);

                String from = droDay.getSelectedItem().toString();
                String to = spinner2.getSelectedItem().toString();
                EditText name = (EditText)findViewById(R.id.activityName);
                EditText desc = (EditText)findViewById(R.id.activityDesc);
                String nama = name.getText().toString();
                String komen = desc.getText().toString();




                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(table.this, UserAreaActivity.class);
                                progressDialog2.dismiss();
                                table.this.startActivity(intent);
                                Toast.makeText(table.this, "Complete submitted",
                                                      Toast.LENGTH_LONG).show();
                            } else {
                                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(table.this);
                                builder.setMessage("Failed submit")
                                        .setNegativeButton("Please try again", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                submitTable submit = new submitTable( nama, from, to, komen, responseListener);
                RequestQueue queue = Volley.newRequestQueue(table.this);
                queue.add(submit);



            }
        });


    }


    public void getData(String data) {



        progressDialog = ProgressDialog.show(table.this,"Loading...",
                "Loading table view, please wait...", false, false);

        String DATA_URL = String.format("http://boolas.000webhostapp.com/getICress.php?value=%1$s", data);


        StringRequest stringRequest23 = new StringRequest(Request.Method.GET, DATA_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject j = null;

                api_course = new ArrayList<>();
                api_group = new ArrayList<>();
                api_start = new ArrayList<>();
                api_end = new ArrayList<>();
                api_day = new ArrayList<>();
                api_room = new ArrayList<>();

                try {
                    j = new JSONObject(response);


                    progressDialog.dismiss();

              //      Toast.makeText(table.this, ".....",
               //             Toast.LENGTH_LONG).show();

                    JSONObject obj1 = j.getJSONObject("uitm");

               //     Toast.makeText(table.this, obj1.toString(),
                //            Toast.LENGTH_LONG).show();

                    JSONObject obj2 = obj1.getJSONObject("dewan");

                    Toast.makeText(table.this, obj2.toString(),
                            Toast.LENGTH_LONG).show();

                    Iterator keys = obj2.keys();


                    while (keys.hasNext()) {
                        String keyValue = (String) keys.next();
                        JSONObject obj3=null;
                        obj3 = obj2.getJSONObject(keyValue);

                  //      String subjek = obj3.optString("Course");
                  //      String kumpulan = obj3.optString("Group");
                  //      String mula = obj3.optString("Start");
                  //      String tamat = obj3.optString("End");
                  //      String hari = obj3.optString("Day");
                  //      String dewan = obj3.optString("Room");

                  //      Toast.makeText(table.this, subjek+" "+kumpulan+" "+mula,
                  //              Toast.LENGTH_LONG).show();

                        api_course.add(obj3.optString("Course"));
                        api_group.add(obj3.optString("Group"));
                        api_start.add(obj3.optString("Start"));
                        api_end.add(obj3.optString("End"));
                        api_day.add(obj3.optString("Day"));
                        api_room.add(obj3.optString("Room"));
                    }

                 //   Toast.makeText(table.this, "berjaya...",
                 //           Toast.LENGTH_LONG).show();


                    //             result = j.getJSONArray(JSON_ARRAY);
                                 displayApi();
                } catch (JSONException e) {
                    progressDialog.dismiss();
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();

            }
        }
        );

        stringRequest23.setRetryPolicy(new DefaultRetryPolicy(
                120000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest23);
    }



    public void displayApi() {
        hashMap = new HashMap<String, String>();
        collectDay = new ArrayList<>();

        hashMap.put("dt1","Monday , 8.30am");
        hashMap.put("dt2","Monday , 8.30am");
        hashMap.put("dt3","Monday, 9.30am");
        hashMap.put("dt4","Monday, 9.30am");
        hashMap.put("dt5","Monday, 10.30am");
        hashMap.put("dt6","Monday, 10.30am");
        hashMap.put("dt7","Monday, 11.30am");
        hashMap.put("dt8","Monday, 11.30am");
        hashMap.put("dt9","Monday, 12.30pm");
        hashMap.put("dt10","Monday, 12.30pm");
        hashMap.put("dt11","Monday, 1.30pm");
        hashMap.put("dt12","Monday, 1.30pm");
        hashMap.put("dt13","Monday, 2.30pm");
        hashMap.put("dt14","Monday, 2.30pm");
        hashMap.put("dt15","Monday, 3.30pm");
        hashMap.put("dt16","Monday, 3.30pm");
        hashMap.put("dt17","Monday, 4.30pm");
        hashMap.put("dt18","Monday, 4.30pm");
        hashMap.put("dt19","Monday, 5.30pm");
        hashMap.put("dt20","Monday, 5.30pm");
        hashMap.put("dt21","Monday, 6.30pm");
        hashMap.put("dt22","Monday, 6.30pm");
        hashMap.put("dt23","Tuesday, 8.30am");
        hashMap.put("dt24","Tuesday, 8.30am");
        hashMap.put("dt25","Tuesday, 9.30am");
        hashMap.put("dt26","Tuesday, 9.30am");
        hashMap.put("dt27","Tuesday, 10.30am");
        hashMap.put("dt28","Tuesday, 10.30am");
        hashMap.put("dt29","Tuesday, 11.30am");
        hashMap.put("dt30","Tuesday, 11.30am");
        hashMap.put("dt31","Tuesday, 12.30pm");
        hashMap.put("dt32","Tuesday, 12.30pm");
        hashMap.put("dt33","Tuesday, 1.30pm");
        hashMap.put("dt34","Tuesday, 1.30pm");
        hashMap.put("dt35","Tuesday, 2.30pm");
        hashMap.put("dt36","Tuesday, 2.30pm");
        hashMap.put("dt37","Tuesday, 3.30pm");
        hashMap.put("dt38","Tuesday, 3.30pm");
        hashMap.put("dt39","Tuesday, 4.30pm");
        hashMap.put("dt40","Tuesday, 4.30pm");
        hashMap.put("dt41","Tuesday, 5.30pm");
        hashMap.put("dt42","Tuesday, 5.30pm");
        hashMap.put("dt43","Tuesday, 6.30pm");
        hashMap.put("dt44","Tuesday, 6.30pm");
        hashMap.put("dt45","Wednesday, 8.30am");
        hashMap.put("dt46","Wednesday, 8.30am");
        hashMap.put("dt47","Wednesday, 9.30am");
        hashMap.put("dt48","Wednesday, 9.30am");
        hashMap.put("dt49","Wednesday, 10.30am");
        hashMap.put("dt50","Wednesday, 10.30am");
        hashMap.put("dt51","Wednesday, 11.30am");
        hashMap.put("dt52","Wednesday, 11.30am");
        hashMap.put("dt53","Wednesday, 12.30pm");
        hashMap.put("dt54","Wednesday, 12.30pm");
        hashMap.put("dt55","Wednesday, 1.30pm");
        hashMap.put("dt56","Wednesday, 1.30pm");
        hashMap.put("dt57","Wednesday, 2.30pm");
        hashMap.put("dt58","Wednesday, 2.30pm");
        hashMap.put("dt59","Wednesday, 3.30pm");
        hashMap.put("dt60","Wednesday, 3.30pm");
        hashMap.put("dt61","Wednesday, 4.30pm");
        hashMap.put("dt62","Wednesday, 4.30pm");
        hashMap.put("dt63","Wednesday, 5.30pm");
        hashMap.put("dt64","Wednesday, 5.30pm");
        hashMap.put("dt65","Wednesday, 6.30pm");
        hashMap.put("dt66","Wednesday, 6.30pm");
        hashMap.put("dt67","Thursday, 8.30am");
        hashMap.put("dt68","Thursday, 8.30am");
        hashMap.put("dt69","Thursday, 9.30am");
        hashMap.put("dt70","Thursday, 9.30am");
        hashMap.put("dt71","Thursday, 10.30am");
        hashMap.put("dt72","Thursday, 10.30am");
        hashMap.put("dt73","Thursday, 11.30am");
        hashMap.put("dt74","Thursday, 11.30am");
        hashMap.put("dt75","Thursday, 12.30pm");
        hashMap.put("dt76","Thursday, 12.30pm");
        hashMap.put("dt77","Thursday, 1.30pm");
        hashMap.put("dt78","Thursday, 1.30pm");
        hashMap.put("dt79","Thursday, 2.30pm");
        hashMap.put("dt80","Thursday, 2.30pm");
        hashMap.put("dt81","Thursday, 3.30pm");
        hashMap.put("dt82","Thursday, 3.30pm");
        hashMap.put("dt83","Thursday, 4.30pm");
        hashMap.put("dt84","Thursday, 4.30pm");
        hashMap.put("dt85","Thursday, 5.30pm");
        hashMap.put("dt86","Thursday, 5.30pm");
        hashMap.put("dt87","Thursday, 6.30pm");
        hashMap.put("dt88","Thursday, 6.30pm");
        hashMap.put("dt89","Friday, 8.30am");
        hashMap.put("dt90","Friday, 8.30am");
        hashMap.put("dt91","Friday, 9.30am");
        hashMap.put("dt92","Friday, 9.30am");
        hashMap.put("dt93","Friday, 10.30am");
        hashMap.put("dt94","Friday, 10.30am");
        hashMap.put("dt95","Friday, 11.30am");
        hashMap.put("dt96","Friday, 11.30am");
        hashMap.put("dt97","Friday, 12.30pm");
        hashMap.put("dt98","Friday, 12.30pm");
        hashMap.put("dt99","Friday, 1.30pm");
        hashMap.put("dt100","Friday, 1.30pm");
        hashMap.put("dt101","Friday, 2.30pm");
        hashMap.put("dt102","Friday, 2.30pm");
        hashMap.put("dt103","Friday, 3.30pm");
        hashMap.put("dt104","Friday, 3.30pm");
        hashMap.put("dt105","Friday, 4.30pm");
        hashMap.put("dt106","Friday, 4.30pm");
        hashMap.put("dt107","Friday, 5.30pm");
        hashMap.put("dt108","Friday, 5.30pm");
        hashMap.put("dt109","Friday, 6.30pm");
        hashMap.put("dt110","Friday, 6.30pm");



        TextView eight = (TextView) findViewById(R.id.eight);
        TextView nine = (TextView) findViewById(R.id.nine);
        TextView ten = (TextView) findViewById(R.id.ten);
        TextView eleven = (TextView) findViewById(R.id.eleven);
        TextView twelve = (TextView) findViewById(R.id.twelve);
        TextView thirteen = (TextView) findViewById(R.id.thirteen);
        TextView fourteen = (TextView) findViewById(R.id.fourteen);
        TextView fiveteen = (TextView) findViewById(R.id.fiveteen);
        TextView sixteen = (TextView) findViewById(R.id.sixteen);
        TextView seventeen = (TextView) findViewById(R.id.seventeen);
        TextView eighteen = (TextView) findViewById(R.id.eighteen);

        TextView mon_eight_one = (TextView) findViewById(R.id.dt1);
        TextView mon_eight_two = (TextView) findViewById(R.id.dt2);
        TextView mon_nine_one = (TextView) findViewById(R.id.dt3);
        TextView mon_nine_two = (TextView) findViewById(R.id.dt4);
        TextView mon_ten_one = (TextView) findViewById(R.id.dt5);
        TextView mon_ten_two = (TextView) findViewById(R.id.dt6);
        TextView mon_eleven_one = (TextView) findViewById(R.id.dt7);
        TextView mon_eleven_two = (TextView) findViewById(R.id.dt8);
        TextView mon_twelve_one = (TextView) findViewById(R.id.dt9);
        TextView mon_twelve_two = (TextView) findViewById(R.id.dt10);
        TextView mon_thirteen_one = (TextView) findViewById(R.id.dt11);
        TextView mon_thirteen_two = (TextView) findViewById(R.id.dt12);
        TextView mon_fourteen_one= (TextView) findViewById(R.id.dt13);
        TextView mon_fourteen_two = (TextView) findViewById(R.id.dt14);
        TextView mon_fiveteen_one = (TextView) findViewById(R.id.dt15);
        TextView mon_fiveteen_two = (TextView) findViewById(R.id.dt16);
        TextView mon_sixteen_one = (TextView) findViewById(R.id.dt17);
        TextView mon_sixteen_two = (TextView) findViewById(R.id.dt18);
        TextView mon_seventeen_one = (TextView) findViewById(R.id.dt19);
        TextView mon_seventeen_two = (TextView) findViewById(R.id.dt20);
        TextView mon_eighteen_one = (TextView) findViewById(R.id.dt21);
        TextView mon_eighteen_two = (TextView) findViewById(R.id.dt22);

        TextView tue_eight_one = (TextView) findViewById(R.id.dt23);
        TextView tue_eight_two = (TextView) findViewById(R.id.dt24);
        TextView tue_nine_one = (TextView) findViewById(R.id.dt25);
        TextView tue_nine_two = (TextView) findViewById(R.id.dt26);
        TextView tue_ten_one = (TextView) findViewById(R.id.dt27);
        TextView tue_ten_two = (TextView) findViewById(R.id.dt28);
        TextView tue_eleven_one = (TextView) findViewById(R.id.dt29);
        TextView tue_eleven_two = (TextView) findViewById(R.id.dt30);
        TextView tue_twelve_one = (TextView) findViewById(R.id.dt31);
        TextView tue_twelve_two = (TextView) findViewById(R.id.dt32);
        TextView tue_thirteen_one = (TextView) findViewById(R.id.dt33);
        TextView tue_thirteen_two = (TextView) findViewById(R.id.dt34);
        TextView tue_fourteen_one= (TextView) findViewById(R.id.dt35);
        TextView tue_fourteen_two = (TextView) findViewById(R.id.dt36);
        TextView tue_fiveteen_one = (TextView) findViewById(R.id.dt37);
        TextView tue_fiveteen_two = (TextView) findViewById(R.id.dt38);
        TextView tue_sixteen_one = (TextView) findViewById(R.id.dt39);
        TextView tue_sixteen_two = (TextView) findViewById(R.id.dt40);
        TextView tue_seventeen_one = (TextView) findViewById(R.id.dt41);
        TextView tue_seventeen_two = (TextView) findViewById(R.id.dt42);
        TextView tue_eighteen_one = (TextView) findViewById(R.id.dt43);
        TextView tue_eighteen_two = (TextView) findViewById(R.id.dt44);

        TextView wed_eight_one = (TextView) findViewById(R.id.dt45);
        TextView wed_eight_two = (TextView) findViewById(R.id.dt46);
        TextView wed_nine_one = (TextView) findViewById(R.id.dt47);
        TextView wed_nine_two = (TextView) findViewById(R.id.dt48);
        TextView wed_ten_one = (TextView) findViewById(R.id.dt49);
        TextView wed_ten_two = (TextView) findViewById(R.id.dt50);
        TextView wed_eleven_one = (TextView) findViewById(R.id.dt51);
        TextView wed_eleven_two = (TextView) findViewById(R.id.dt52);
        TextView wed_twelve_one = (TextView) findViewById(R.id.dt53);
        TextView wed_twelve_two = (TextView) findViewById(R.id.dt54);
        TextView wed_thirteen_one = (TextView) findViewById(R.id.dt55);
        TextView wed_thirteen_two = (TextView) findViewById(R.id.dt56);
        TextView wed_fourteen_one= (TextView) findViewById(R.id.dt57);
        TextView wed_fourteen_two = (TextView) findViewById(R.id.dt58);
        TextView wed_fiveteen_one = (TextView) findViewById(R.id.dt59);
        TextView wed_fiveteen_two = (TextView) findViewById(R.id.dt60);
        TextView wed_sixteen_one = (TextView) findViewById(R.id.dt61);
        TextView wed_sixteen_two = (TextView) findViewById(R.id.dt62);
        TextView wed_seventeen_one = (TextView) findViewById(R.id.dt63);
        TextView wed_seventeen_two = (TextView) findViewById(R.id.dt64);
        TextView wed_eighteen_one = (TextView) findViewById(R.id.dt65);
        TextView wed_eighteen_two = (TextView) findViewById(R.id.dt66);

        TextView thu_eight_one = (TextView) findViewById(R.id.dt67);
        TextView thu_eight_two = (TextView) findViewById(R.id.dt68);
        TextView thu_nine_one = (TextView) findViewById(R.id.dt69);
        TextView thu_nine_two = (TextView) findViewById(R.id.dt70);
        TextView thu_ten_one = (TextView) findViewById(R.id.dt71);
        TextView thu_ten_two = (TextView) findViewById(R.id.dt72);
        TextView thu_eleven_one = (TextView) findViewById(R.id.dt73);
        TextView thu_eleven_two = (TextView) findViewById(R.id.dt74);
        TextView thu_twelve_one = (TextView) findViewById(R.id.dt75);
        TextView thu_twelve_two = (TextView) findViewById(R.id.dt76);
        TextView thu_thirteen_one = (TextView) findViewById(R.id.dt77);
        TextView thu_thirteen_two = (TextView) findViewById(R.id.dt78);
        TextView thu_fourteen_one= (TextView) findViewById(R.id.dt79);
        TextView thu_fourteen_two = (TextView) findViewById(R.id.dt80);
        TextView thu_fiveteen_one = (TextView) findViewById(R.id.dt81);
        TextView thu_fiveteen_two = (TextView) findViewById(R.id.dt82);
        TextView thu_sixteen_one = (TextView) findViewById(R.id.dt83);
        TextView thu_sixteen_two = (TextView) findViewById(R.id.dt84);
        TextView thu_seventeen_one = (TextView) findViewById(R.id.dt85);
        TextView thu_seventeen_two = (TextView) findViewById(R.id.dt86);
        TextView thu_eighteen_one = (TextView) findViewById(R.id.dt87);
        TextView thu_eighteen_two = (TextView) findViewById(R.id.dt88);

        TextView fri_eight_one = (TextView) findViewById(R.id.dt89);
        TextView fri_eight_two = (TextView) findViewById(R.id.dt90);
        TextView fri_nine_one = (TextView) findViewById(R.id.dt91);
        TextView fri_nine_two = (TextView) findViewById(R.id.dt92);
        TextView fri_ten_one = (TextView) findViewById(R.id.dt93);
        TextView fri_ten_two = (TextView) findViewById(R.id.dt94);
        TextView fri_eleven_one = (TextView) findViewById(R.id.dt95);
        TextView fri_eleven_two = (TextView) findViewById(R.id.dt96);
        TextView fri_twelve_one = (TextView) findViewById(R.id.dt97);
        TextView fri_twelve_two = (TextView) findViewById(R.id.dt98);
        TextView fri_thirteen_one = (TextView) findViewById(R.id.dt99);
        TextView fri_thirteen_two = (TextView) findViewById(R.id.dt100);
        TextView fri_fourteen_one= (TextView) findViewById(R.id.dt101);
        TextView fri_fourteen_two = (TextView) findViewById(R.id.dt102);
        TextView fri_fiveteen_one = (TextView) findViewById(R.id.dt103);
        TextView fri_fiveteen_two = (TextView) findViewById(R.id.dt104);
        TextView fri_sixteen_one = (TextView) findViewById(R.id.dt105);
        TextView fri_sixteen_two = (TextView) findViewById(R.id.dt106);
        TextView fri_seventeen_one = (TextView) findViewById(R.id.dt107);
        TextView fri_seventeen_two = (TextView) findViewById(R.id.dt108);
        TextView fri_eighteen_one = (TextView) findViewById(R.id.dt109);
        TextView fri_eighteen_two  = (TextView) findViewById(R.id.dt110);

// Try to constructing a very simpify code from long one below but out of an idea

        /*
        for (int i = 1; i <= 22; i++) {
            String wee = "dt"+i;
            int id  = getResources().getIdentifier(wee, "id", getPackageName());

            for (int y = 0; y < api_day.size(); y++){
                if (api_day.get(y).toString().replaceAll("\\s+","").toLowerCase() == "monday" &&
                        isnin.get(wee).replaceAll("\\s+","").split(",")[1].split("\\.")[0] ==
                                api_start.get(y).replaceAll("\\s+","").split(":")[0]){


                }
            }

        }

        */


        //Here come the long one
        for (int i = 0; i < api_day.size(); i++) {

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("monday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("8:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("10:20")){

                mon_eight_two.setText("     N/A     ");
                mon_eight_two.setBackgroundColor(Color.WHITE);

                mon_nine_one.setText("     N/A     ");
                mon_nine_one.setBackgroundColor(Color.WHITE);

                mon_nine_two.setText("     N/A     ");
                mon_nine_two.setBackgroundColor(Color.WHITE);

                mon_ten_one.setText("     N/A     ");
                mon_ten_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("monday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("9:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("11:20")){

                mon_nine_two.setText("     N/A     ");
                mon_nine_two.setBackgroundColor(Color.WHITE);

                mon_ten_one.setText("     N/A     ");
                mon_ten_one.setBackgroundColor(Color.WHITE);

                mon_ten_two.setText("     N/A     ");
                mon_ten_two.setBackgroundColor(Color.WHITE);

                mon_eleven_one.setText("     N/A     ");
                mon_eleven_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("monday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("10:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("12:20")) {

                mon_ten_two.setText("     N/A     ");
                mon_ten_two.setBackgroundColor(Color.WHITE);

                mon_eleven_one.setText("     N/A     ");
                mon_eleven_one.setBackgroundColor(Color.WHITE);

                mon_eleven_two.setText("     N/A     ");
                mon_eleven_two.setBackgroundColor(Color.WHITE);

                mon_twelve_one.setText("     N/A     ");
                mon_twelve_one.setBackgroundColor(Color.WHITE);

            }



            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("monday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("11:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("1:20")) {

                mon_eleven_two.setText("     N/A     ");
                mon_eleven_two.setBackgroundColor(Color.WHITE);

                mon_twelve_one.setText("     N/A     ");
                mon_twelve_one.setBackgroundColor(Color.WHITE);

                mon_twelve_two.setText("     N/A     ");
                mon_twelve_two.setBackgroundColor(Color.WHITE);

                mon_thirteen_one.setText("     N/A     ");
                mon_thirteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("monday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("12:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("2:20")) {

                mon_twelve_two.setText("     N/A     ");
                mon_twelve_two.setBackgroundColor(Color.WHITE);

                mon_thirteen_one.setText("     N/A     ");
                mon_thirteen_one.setBackgroundColor(Color.WHITE);

                mon_thirteen_two.setText("     N/A     ");
                mon_thirteen_two.setBackgroundColor(Color.WHITE);

                mon_fourteen_one.setText("     N/A     ");
                mon_fourteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("monday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("1:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("3:20")) {


                        mon_thirteen_two.setText("     N/A     ");
                        mon_thirteen_two.setBackgroundColor(Color.WHITE);

                        mon_fourteen_one.setText("     N/A     ");
                        mon_fourteen_one.setBackgroundColor(Color.WHITE);

                        mon_fourteen_two.setText("     N/A     ");
                        mon_fourteen_two.setBackgroundColor(Color.WHITE);

                        mon_fiveteen_one.setText("     N/A     ");
                        mon_fiveteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("monday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("2:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("4:20")) {

                mon_fourteen_two.setText("     N/A     ");
                mon_fourteen_two.setBackgroundColor(Color.WHITE);

                mon_fiveteen_one.setText("     N/A     ");
                mon_fiveteen_one.setBackgroundColor(Color.WHITE);

                mon_fiveteen_two.setText("     N/A     ");
                mon_fiveteen_two.setBackgroundColor(Color.WHITE);

                mon_sixteen_one.setText("     N/A     ");
                mon_sixteen_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("monday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("3:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("5:20")) {

                mon_fiveteen_two.setText("     N/A     ");
                mon_fiveteen_two.setBackgroundColor(Color.WHITE);

                mon_sixteen_one.setText("     N/A     ");
                mon_sixteen_one.setBackgroundColor(Color.WHITE);

                mon_sixteen_two.setText("     N/A     ");
                mon_sixteen_two.setBackgroundColor(Color.WHITE);

                mon_seventeen_one.setText("     N/A     ");
                mon_seventeen_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("monday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("4:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("6:20")) {

                mon_sixteen_two.setText("     N/A     ");
                mon_sixteen_two.setBackgroundColor(Color.WHITE);

                mon_seventeen_one.setText("     N/A     ");
                mon_seventeen_one.setBackgroundColor(Color.WHITE);

                mon_seventeen_two.setText("     N/A     ");
                mon_seventeen_two.setBackgroundColor(Color.WHITE);

                mon_eighteen_one.setText("     N/A     ");
                mon_eighteen_one.setBackgroundColor(Color.WHITE);

            }








            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("tuesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("8:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("10:20")){

                tue_eight_two.setText("     N/A     ");
                tue_eight_two.setBackgroundColor(Color.WHITE);

                tue_nine_one.setText("     N/A     ");
                tue_nine_one.setBackgroundColor(Color.WHITE);

                tue_nine_two.setText("     N/A     ");
                tue_nine_two.setBackgroundColor(Color.WHITE);

                tue_ten_one.setText("     N/A     ");
                tue_ten_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("tuesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("9:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("11:20")){

                tue_nine_two.setText("     N/A     ");
                tue_nine_two.setBackgroundColor(Color.WHITE);

                tue_ten_one.setText("     N/A     ");
                tue_ten_one.setBackgroundColor(Color.WHITE);

                tue_ten_two.setText("     N/A     ");
                tue_ten_two.setBackgroundColor(Color.WHITE);

                tue_eleven_one.setText("     N/A     ");
                tue_eleven_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("tuesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("10:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("12:20")) {

                tue_ten_two.setText("     N/A     ");
                tue_ten_two.setBackgroundColor(Color.WHITE);

                tue_eleven_one.setText("     N/A     ");
                tue_eleven_one.setBackgroundColor(Color.WHITE);

                tue_eleven_two.setText("     N/A     ");
                tue_eleven_two.setBackgroundColor(Color.WHITE);

                tue_twelve_one.setText("     N/A     ");
                tue_twelve_one.setBackgroundColor(Color.WHITE);

            }



            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("tuesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("11:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("1:20")) {

                tue_eleven_two.setText("     N/A     ");
                tue_eleven_two.setBackgroundColor(Color.WHITE);

                tue_twelve_one.setText("     N/A     ");
                tue_twelve_one.setBackgroundColor(Color.WHITE);

                tue_twelve_two.setText("     N/A     ");
                tue_twelve_two.setBackgroundColor(Color.WHITE);

                tue_thirteen_one.setText("     N/A     ");
                tue_thirteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("tuesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("12:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("2:20")) {

                tue_twelve_two.setText("     N/A     ");
                tue_twelve_two.setBackgroundColor(Color.WHITE);

                tue_thirteen_one.setText("     N/A     ");
                tue_thirteen_one.setBackgroundColor(Color.WHITE);

                tue_thirteen_two.setText("     N/A     ");
                tue_thirteen_two.setBackgroundColor(Color.WHITE);

                tue_fourteen_one.setText("     N/A     ");
                tue_fourteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("tuesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("1:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("3:20")) {


                tue_thirteen_two.setText("     N/A     ");
                tue_thirteen_two.setBackgroundColor(Color.WHITE);

                tue_fourteen_one.setText("     N/A     ");
                tue_fourteen_one.setBackgroundColor(Color.WHITE);

                tue_fourteen_two.setText("     N/A     ");
                tue_fourteen_two.setBackgroundColor(Color.WHITE);

                tue_fiveteen_one.setText("     N/A     ");
                tue_fiveteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("tuesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("2:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("4:20")) {

                tue_fourteen_two.setText("     N/A     ");
                tue_fourteen_two.setBackgroundColor(Color.WHITE);

                tue_fiveteen_one.setText("     N/A     ");
                tue_fiveteen_one.setBackgroundColor(Color.WHITE);

                tue_fiveteen_two.setText("     N/A     ");
                tue_fiveteen_two.setBackgroundColor(Color.WHITE);

                tue_sixteen_one.setText("     N/A     ");
                tue_sixteen_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("tuesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("3:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("5:20")) {

                tue_fiveteen_two.setText("     N/A     ");
                tue_fiveteen_two.setBackgroundColor(Color.WHITE);

                tue_sixteen_one.setText("     N/A     ");
                tue_sixteen_one.setBackgroundColor(Color.WHITE);

                tue_sixteen_two.setText("     N/A     ");
                tue_sixteen_two.setBackgroundColor(Color.WHITE);

                tue_seventeen_one.setText("     N/A     ");
                tue_seventeen_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("tuesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("4:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("6:20")) {

                tue_sixteen_two.setText("     N/A     ");
                tue_sixteen_two.setBackgroundColor(Color.WHITE);

                tue_seventeen_one.setText("     N/A     ");
                tue_seventeen_one.setBackgroundColor(Color.WHITE);

                tue_seventeen_two.setText("     N/A     ");
                tue_seventeen_two.setBackgroundColor(Color.WHITE);

                tue_eighteen_one.setText("     N/A     ");
                tue_eighteen_one.setBackgroundColor(Color.WHITE);

            }







            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("wednesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("8:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("10:20")){

                wed_eight_two.setText("     N/A     ");
                wed_eight_two.setBackgroundColor(Color.WHITE);

                wed_nine_one.setText("     N/A     ");
                wed_nine_one.setBackgroundColor(Color.WHITE);

                wed_nine_two.setText("     N/A     ");
                wed_nine_two.setBackgroundColor(Color.WHITE);

                wed_ten_one.setText("     N/A     ");
                wed_ten_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("wednesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("9:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("11:20")){

                wed_nine_two.setText("     N/A     ");
                wed_nine_two.setBackgroundColor(Color.WHITE);

                wed_ten_one.setText("     N/A     ");
                wed_ten_one.setBackgroundColor(Color.WHITE);

                wed_ten_two.setText("     N/A     ");
                wed_ten_two.setBackgroundColor(Color.WHITE);

                wed_eleven_one.setText("     N/A     ");
                wed_eleven_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("wednesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("10:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("12:20")) {

                wed_ten_two.setText("     N/A     ");
                wed_ten_two.setBackgroundColor(Color.WHITE);

                wed_eleven_one.setText("     N/A     ");
                wed_eleven_one.setBackgroundColor(Color.WHITE);

                wed_eleven_two.setText("     N/A     ");
                wed_eleven_two.setBackgroundColor(Color.WHITE);

                wed_twelve_one.setText("     N/A     ");
                wed_twelve_one.setBackgroundColor(Color.WHITE);

            }



            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("wednesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("11:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("1:20")) {

                wed_eleven_two.setText("     N/A     ");
                wed_eleven_two.setBackgroundColor(Color.WHITE);

                wed_twelve_one.setText("     N/A     ");
                wed_twelve_one.setBackgroundColor(Color.WHITE);

                wed_twelve_two.setText("     N/A     ");
                wed_twelve_two.setBackgroundColor(Color.WHITE);

                wed_thirteen_one.setText("     N/A     ");
                wed_thirteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("wednesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("12:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("2:20")) {

                wed_twelve_two.setText("     N/A     ");
                wed_twelve_two.setBackgroundColor(Color.WHITE);

                wed_thirteen_one.setText("     N/A     ");
                wed_thirteen_one.setBackgroundColor(Color.WHITE);

                wed_thirteen_two.setText("     N/A     ");
                wed_thirteen_two.setBackgroundColor(Color.WHITE);

                wed_fourteen_one.setText("     N/A     ");
                wed_fourteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("wednesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("1:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("3:20")) {


                wed_thirteen_two.setText("     N/A     ");
                wed_thirteen_two.setBackgroundColor(Color.WHITE);

                wed_fourteen_one.setText("     N/A     ");
                wed_fourteen_one.setBackgroundColor(Color.WHITE);

                wed_fourteen_two.setText("     N/A     ");
                wed_fourteen_two.setBackgroundColor(Color.WHITE);

                wed_fiveteen_one.setText("     N/A     ");
                wed_fiveteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("wednesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("2:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("4:20")) {

                wed_fourteen_two.setText("     N/A     ");
                wed_fourteen_two.setBackgroundColor(Color.WHITE);

                wed_fiveteen_one.setText("     N/A     ");
                wed_fiveteen_one.setBackgroundColor(Color.WHITE);

                wed_fiveteen_two.setText("     N/A     ");
                wed_fiveteen_two.setBackgroundColor(Color.WHITE);

                wed_sixteen_one.setText("     N/A     ");
                wed_sixteen_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("wednesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("3:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("5:20")) {

                wed_fiveteen_two.setText("     N/A     ");
                wed_fiveteen_two.setBackgroundColor(Color.WHITE);

                wed_sixteen_one.setText("     N/A     ");
                wed_sixteen_one.setBackgroundColor(Color.WHITE);

                wed_sixteen_two.setText("     N/A     ");
                wed_sixteen_two.setBackgroundColor(Color.WHITE);

                wed_seventeen_one.setText("     N/A     ");
                wed_seventeen_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("wednesday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("4:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("6:20")) {

                wed_sixteen_two.setText("     N/A     ");
                wed_sixteen_two.setBackgroundColor(Color.WHITE);

                wed_seventeen_one.setText("     N/A     ");
                wed_seventeen_one.setBackgroundColor(Color.WHITE);

                wed_seventeen_two.setText("     N/A     ");
                wed_seventeen_two.setBackgroundColor(Color.WHITE);

                wed_eighteen_one.setText("     N/A     ");
                wed_eighteen_one.setBackgroundColor(Color.WHITE);

            }






            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("thursday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("8:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("10:20")){

                thu_eight_two.setText("     N/A     ");
                thu_eight_two.setBackgroundColor(Color.WHITE);

                thu_nine_one.setText("     N/A     ");
                thu_nine_one.setBackgroundColor(Color.WHITE);

                thu_nine_two.setText("     N/A     ");
                thu_nine_two.setBackgroundColor(Color.WHITE);

                thu_ten_one.setText("     N/A     ");
                thu_ten_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("thursday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("9:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("11:20")){

                thu_nine_two.setText("     N/A     ");
                thu_nine_two.setBackgroundColor(Color.WHITE);

                thu_ten_one.setText("     N/A     ");
                thu_ten_one.setBackgroundColor(Color.WHITE);

                thu_ten_two.setText("     N/A     ");
                thu_ten_two.setBackgroundColor(Color.WHITE);

                thu_eleven_one.setText("     N/A     ");
                thu_eleven_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("thursday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("10:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("12:20")) {

                thu_ten_two.setText("     N/A     ");
                thu_ten_two.setBackgroundColor(Color.WHITE);

                thu_eleven_one.setText("     N/A     ");
                thu_eleven_one.setBackgroundColor(Color.WHITE);

                thu_eleven_two.setText("     N/A     ");
                thu_eleven_two.setBackgroundColor(Color.WHITE);

                thu_twelve_one.setText("     N/A     ");
                thu_twelve_one.setBackgroundColor(Color.WHITE);

            }



            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("thursday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("11:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("1:20")) {

                thu_eleven_two.setText("     N/A     ");
                thu_eleven_two.setBackgroundColor(Color.WHITE);

                thu_twelve_one.setText("     N/A     ");
                thu_twelve_one.setBackgroundColor(Color.WHITE);

                thu_twelve_two.setText("     N/A     ");
                thu_twelve_two.setBackgroundColor(Color.WHITE);

                thu_thirteen_one.setText("     N/A     ");
                thu_thirteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("thursday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("12:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("2:20")) {

                thu_twelve_two.setText("     N/A     ");
                thu_twelve_two.setBackgroundColor(Color.WHITE);

                thu_thirteen_one.setText("     N/A     ");
                thu_thirteen_one.setBackgroundColor(Color.WHITE);

                thu_thirteen_two.setText("     N/A     ");
                thu_thirteen_two.setBackgroundColor(Color.WHITE);

                thu_fourteen_one.setText("     N/A     ");
                thu_fourteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("thursday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("1:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("3:20")) {


                thu_thirteen_two.setText("     N/A     ");
                thu_thirteen_two.setBackgroundColor(Color.WHITE);

                thu_fourteen_one.setText("     N/A     ");
                thu_fourteen_one.setBackgroundColor(Color.WHITE);

                thu_fourteen_two.setText("     N/A     ");
                thu_fourteen_two.setBackgroundColor(Color.WHITE);

                thu_fiveteen_one.setText("     N/A     ");
                thu_fiveteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("thursday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("2:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("4:20")) {

                thu_fourteen_two.setText("     N/A     ");
                thu_fourteen_two.setBackgroundColor(Color.WHITE);

                thu_fiveteen_one.setText("     N/A     ");
                thu_fiveteen_one.setBackgroundColor(Color.WHITE);

                thu_fiveteen_two.setText("     N/A     ");
                thu_fiveteen_two.setBackgroundColor(Color.WHITE);

                thu_sixteen_one.setText("     N/A     ");
                thu_sixteen_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("thursday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("3:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("5:20")) {

                thu_fiveteen_two.setText("     N/A     ");
                thu_fiveteen_two.setBackgroundColor(Color.WHITE);

                thu_sixteen_one.setText("     N/A     ");
                thu_sixteen_one.setBackgroundColor(Color.WHITE);

                thu_sixteen_two.setText("     N/A     ");
                thu_sixteen_two.setBackgroundColor(Color.WHITE);

                thu_seventeen_one.setText("     N/A     ");
                thu_seventeen_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("thursday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("4:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("6:20")) {

                thu_sixteen_two.setText("     N/A     ");
                thu_sixteen_two.setBackgroundColor(Color.WHITE);

                thu_seventeen_one.setText("     N/A     ");
                thu_seventeen_one.setBackgroundColor(Color.WHITE);

                thu_seventeen_two.setText("     N/A     ");
                thu_seventeen_two.setBackgroundColor(Color.WHITE);

                thu_eighteen_one.setText("     N/A     ");
                thu_eighteen_one.setBackgroundColor(Color.WHITE);

            }






            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("friday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("8:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("10:20")){

                fri_eight_two.setText("     N/A     ");
                fri_eight_two.setBackgroundColor(Color.WHITE);

                fri_nine_one.setText("     N/A     ");
                fri_nine_one.setBackgroundColor(Color.WHITE);

                fri_nine_two.setText("     N/A     ");
                fri_nine_two.setBackgroundColor(Color.WHITE);

                fri_ten_one.setText("     N/A     ");
                fri_ten_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("friday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("9:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("11:20")){

                fri_nine_two.setText("     N/A     ");
                fri_nine_two.setBackgroundColor(Color.WHITE);

                fri_ten_one.setText("     N/A     ");
                fri_ten_one.setBackgroundColor(Color.WHITE);

                fri_ten_two.setText("     N/A     ");
                fri_ten_two.setBackgroundColor(Color.WHITE);

                fri_eleven_one.setText("     N/A     ");
                fri_eleven_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("friday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("10:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("12:20")) {

                fri_ten_two.setText("     N/A     ");
                fri_ten_two.setBackgroundColor(Color.WHITE);

                fri_eleven_one.setText("     N/A     ");
                fri_eleven_one.setBackgroundColor(Color.WHITE);

                fri_eleven_two.setText("     N/A     ");
                fri_eleven_two.setBackgroundColor(Color.WHITE);

                fri_twelve_one.setText("     N/A     ");
                fri_twelve_one.setBackgroundColor(Color.WHITE);

            }



            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("friday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("11:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("1:20")) {

                fri_eleven_two.setText("     N/A     ");
                fri_eleven_two.setBackgroundColor(Color.WHITE);

                fri_twelve_one.setText("     N/A     ");
                fri_twelve_one.setBackgroundColor(Color.WHITE);

                fri_twelve_two.setText("     N/A     ");
                fri_twelve_two.setBackgroundColor(Color.WHITE);

                fri_thirteen_one.setText("     N/A     ");
                fri_thirteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("friday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("12:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("2:20")) {

                fri_twelve_two.setText("     N/A     ");
                fri_twelve_two.setBackgroundColor(Color.WHITE);

                fri_thirteen_one.setText("     N/A     ");
                fri_thirteen_one.setBackgroundColor(Color.WHITE);

                fri_thirteen_two.setText("     N/A     ");
                fri_thirteen_two.setBackgroundColor(Color.WHITE);

                fri_fourteen_one.setText("     N/A     ");
                fri_fourteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("friday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("1:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("3:20")) {


                fri_thirteen_two.setText("     N/A     ");
                fri_thirteen_two.setBackgroundColor(Color.WHITE);

                fri_fourteen_one.setText("     N/A     ");
                fri_fourteen_one.setBackgroundColor(Color.WHITE);

                fri_fourteen_two.setText("     N/A     ");
                fri_fourteen_two.setBackgroundColor(Color.WHITE);

                fri_fiveteen_one.setText("     N/A     ");
                fri_fiveteen_one.setBackgroundColor(Color.WHITE);

            }


            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("friday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("2:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("4:20")) {

                fri_fourteen_two.setText("     N/A     ");
                fri_fourteen_two.setBackgroundColor(Color.WHITE);

                fri_fiveteen_one.setText("     N/A     ");
                fri_fiveteen_one.setBackgroundColor(Color.WHITE);

                fri_fiveteen_two.setText("     N/A     ");
                fri_fiveteen_two.setBackgroundColor(Color.WHITE);

                fri_sixteen_one.setText("     N/A     ");
                fri_sixteen_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("friday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("3:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("5:20")) {

                fri_fiveteen_two.setText("     N/A     ");
                fri_fiveteen_two.setBackgroundColor(Color.WHITE);

                fri_sixteen_one.setText("     N/A     ");
                fri_sixteen_one.setBackgroundColor(Color.WHITE);

                fri_sixteen_two.setText("     N/A     ");
                fri_sixteen_two.setBackgroundColor(Color.WHITE);

                fri_seventeen_one.setText("     N/A     ");
                fri_seventeen_one.setBackgroundColor(Color.WHITE);

            }

            if(api_day.get(i).toString().replaceAll("\\s+","").toLowerCase().contains("friday") &&
                    api_start.get(i).toString().replaceAll("\\s+","").contains("4:30") &&
                    api_end.get(i).toString().replaceAll("\\s+","").contains("6:20")) {

                fri_sixteen_two.setText("     N/A     ");
                fri_sixteen_two.setBackgroundColor(Color.WHITE);

                fri_seventeen_one.setText("     N/A     ");
                fri_seventeen_one.setBackgroundColor(Color.WHITE);

                fri_seventeen_two.setText("     N/A     ");
                fri_seventeen_two.setBackgroundColor(Color.WHITE);

                fri_eighteen_one.setText("     N/A     ");
                fri_eighteen_one.setBackgroundColor(Color.WHITE);

            }

        }




        for (int i = 2; i < 111; i+=2) {
            String wee = "dt"+i;
            int id  = getResources().getIdentifier(wee, "id", getPackageName());
            if (id != 0 && i != 22 && i != 44 && i != 66 && i != 88 && i != 110) {
                TextView textView = (TextView) findViewById(id);
                String haha = textView.getText().toString();
                if(haha != "     N/A     "){


                    String day = hashMap.get(wee);
                    collectDay.add(day);
                }

            }

        }

        arrayAdapter = new ArrayAdapter<String>(table.this, android.R.layout.simple_spinner_dropdown_item, collectDay);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        droDay.setAdapter(arrayAdapter);




    }



}
