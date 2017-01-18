package com.rush.wender.boolas;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Owner on 07/11/2016.
 */

public class LoginRequest extends StringRequest{

    private static final String LOGIN_REQUEST_URL = "http://boolas.000webhostapp.com/Login.php";
    private Map<String, String> params;


    public LoginRequest(String username, String password, Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("no", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams () {
        return params;
    }
}
