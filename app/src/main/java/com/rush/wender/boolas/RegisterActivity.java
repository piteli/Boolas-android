package com.rush.wender.boolas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity  implements Spinner.OnItemSelectedListener
{

    private Spinner regFac;
    private HashMap<String,String> students;
    private ArrayList<String> students2;
    private HashMap<String,String> students3;
    private ArrayList<String> students4;
    private JSONArray result;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter2;
    String[] spinnerArray;
    private Spinner regDep;

    private String id_faculty;
    private String faculty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        students2 = new ArrayList<String>();

        students = new HashMap<String,String>();



        final EditText regName = (EditText) findViewById(R.id.regName);
        final EditText regNo = (EditText) findViewById(R.id.regNo);
        final EditText regPass = (EditText) findViewById(R.id.regPass);
        final EditText regPhone = (EditText) findViewById(R.id.regPhone);
        final EditText regEmail = (EditText) findViewById(R.id.regEmail);
        regFac = (Spinner) findViewById(R.id.regFac);
       // final Spinner regDep = (Spinner) findViewById(R.id.regDep);
       // final Spinner regPos = (Spinner) findViewById(R.id.regPos);

        regFac.setOnItemSelectedListener(this);
         getData();

        final Button regButton = (Button) findViewById(R.id.regButton);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = regName.getText().toString();
                final String no = regNo.getText().toString();
                final String password = regPass.getText().toString();
                final String phone = regPhone.getText().toString();
                final String email = regEmail.getText().toString();
                final String fakulti = regFac.getSelectedItem().toString();
                final String id_fakulti = students.get(fakulti).toString();
                final String department = regDep.getSelectedItem().toString();
                final String id_department = students3.get(department).toString();



                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("gagal laaaa")
                                        .setNegativeButton("Cuba Sekali lagi.. Dongibab", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name, no, password, phone, email, id_fakulti, id_department, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }


    public void getData(){
        StringRequest getData = new StringRequest(FacQueryDataConfig.DATA_URL, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                JSONObject j = null;

                try{
                    j = new JSONObject(response);

                    result = j.getJSONArray(FacQueryDataConfig.JSON_ARRAY);
                    getStudents(result);
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(getData);
    }

    public void getStudents(JSONArray j){

        for(int i=0; i<j.length(); i++){
            try{
                JSONObject jsonObject = j.getJSONObject(i);
                students.put(jsonObject.getString(FacQueryDataConfig.FAC_NAME),jsonObject.getString(FacQueryDataConfig.FAC_ID));
                students2.add(jsonObject.getString(FacQueryDataConfig.FAC_NAME));
            }catch(JSONException e){
                e.printStackTrace();
            }
        }

        adapter = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_spinner_dropdown_item, students2) {

            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount()-1;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regFac.setAdapter(adapter);

        regFac.setSelection(adapter.getCount());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        faculty = regFac.getSelectedItem().toString();
        id_faculty = students.get(faculty);

      /*  AlertDialog.Builder builder3 = new AlertDialog.Builder(RegisterActivity.this);
        builder3.setMessage(id_faculty)
                .setNegativeButton("Cuba Sekali lagi.. Dongibab", null)
                .create()
                .show();            */


            regDep = (Spinner) findViewById(R.id.spinnerDep);
            regDep.setVisibility(View.VISIBLE);



        getData2(id_faculty);

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void getData2(String id) {

          String DATA_URL = String.format("http://192.168.0.105/blast/QueryDataDepartment.php?data=%1$s",
                  id);

       // String DATA_URL = "https://api.myjson.com/bins/ml837";

        StringRequest getData2 = new StringRequest(Request.Method.GET, DATA_URL, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                JSONObject j = null;
                JSONArray result2;

                try{
                    j = new JSONObject(response);

                    result2 = j.getJSONArray("result");


                    getStudents2(result2);
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        getData2.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(getData2);
    }


    public void getStudents2(JSONArray j){
            students3 = new HashMap<String, String>();
            students4 = new ArrayList<String>();

        for(int i=0; i<j.length(); i++){
            try{
                JSONObject jsonObject = j.getJSONObject(i);
                students3.put(jsonObject.getString("name"),jsonObject.getString("id"));
                students4.add(jsonObject.getString("name"));
            }catch(JSONException e){
                e.printStackTrace();
            }
        }

        adapter2 = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_spinner_dropdown_item, students4);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regDep.setAdapter(adapter2);

    }





}
