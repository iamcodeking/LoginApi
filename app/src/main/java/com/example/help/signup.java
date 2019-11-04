package com.example.help;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {
    Button signup;
    EditText usersi,passsi,phonesi;
    String siuser,sipass,siphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup=findViewById(R.id.confirm);
        usersi=findViewById(R.id.siname);
        passsi=findViewById(R.id.sipass);
        phonesi=findViewById(R.id.siphone);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siuser=usersi.getText().toString();
                sipass=passsi.getText().toString();
                siphone=phonesi.getText().toString();
                String url = "http://192.168.29.32:8080/signup.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                          Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> map=new HashMap<>();
                        map.put("username",siuser);
                        map.put("password",sipass);
                        map.put("phone",siphone);
                        return map;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }

        });
    }

}
