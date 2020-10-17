package com.example.help;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button login;
    TextView sign;
    String user1;
    String pass1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.user);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.login);
        sign=findViewById(R.id.signup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 user1=user.getText().toString();
                 pass1=pass.getText().toString();
                String url = "http://(your pc address )/loginapi.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                      //  Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                        if (response.equals("yes")) {
                            Toast.makeText(MainActivity.this, "Please Wait..", Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this, "logging...", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "incorrect username/password", Toast.LENGTH_SHORT).show();
                             Toast.makeText(MainActivity.this, "Please try again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> map=new HashMap<>();
                        map.put("username",user1);
                        map.put("password",pass1);
                        return map;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
                }

            });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,signup.class);
                startActivity(intent);
            }
        });
    }
}
