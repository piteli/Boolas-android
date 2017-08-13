package com.rush.wender.boolas;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
// import android.text.method.LinkMovementMethod;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button inButang = (Button) findViewById(R.id.inButang);
        inButang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserAreaActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });


        ///////////    set component to each id   /////////////////
        /*

        Toast.makeText(MainActivity.this, "id: 12345",
                             Toast.LENGTH_LONG).show();

        Toast.makeText(MainActivity.this, "password: pass",
                Toast.LENGTH_LONG).show();

        final EditText inNo = (EditText) findViewById(R.id.inNo);
        final EditText inPass = (EditText) findViewById(R.id.inPass);
        final Button inButang = (Button) findViewById(R.id.inButang);
        final TextView inReg = (TextView) findViewById(R.id.inReg);

        */


        ////////////////////   register redirect ////////////////////////////

        /*
        inReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        */

        /////////////////    login-button submit json ////////////////////////
        /*

        inButang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = inNo.getText().toString();
                final String password = inPass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            if(success){
                                String name = jsonObject.getString("name");
                                String phone = jsonObject.getString("phone");
                                Intent intent = new Intent(MainActivity.this, UserAreaActivity.class);
                                intent.putExtra("name",name);
                                intent.putExtra("phone",phone);
                                MainActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("gagal laaaa")
                                        .setNegativeButton("Cuba Sekali lagi.. Dongibab", null)
                                        .create()
                                        .show();
                            }

                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                        }
                };

                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                requestQueue.add(loginRequest);
            }
        });
                    */

    }


}
