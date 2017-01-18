package com.rush.wender.boolas;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Owner on 07/11/2016.
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://192.168.0.105/blast/Register.php";
    private Map<String, String> params;



    public RegisterRequest(String name, String no, String password, String phone, String email, String faculty, String department, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("no", no);
        params.put("password", password);
        params.put("phone", phone);
        params.put("email", email);
        params.put("faculty", faculty);
        params.put("department", department);


    }

    @Override
    public Map<String, String> getParams () {
        return params;
    }

}
