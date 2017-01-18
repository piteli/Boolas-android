package com.rush.wender.boolas;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by naninaliko on 17/1/2017.
 */

public class submitTable extends StringRequest {

    private static final String SUBMIT_REQUEST_URL = "http://boolas.000webhostapp.com/submit.php";
    private Map<String, String> params;



    public submitTable(String nama, String fom, String to, String komen, Response.Listener<String> listener) {
        super(Request.Method.POST, SUBMIT_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("nama", nama);
        params.put("fom", fom);
        params.put("to", to);
        params.put("komen", komen);



    }


    @Override
    public Map<String, String> getParams () {
        return params;
    }
}
