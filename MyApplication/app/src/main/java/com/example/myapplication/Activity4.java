package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity {
    Button button3;
    EditText editTextEmail, editTextPassword;
    /*Connection ConError;
    private static String loginUrl = "http://192.168.18.39:80/index/login.php";
    Output result;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        /*result = new Output(this);*/

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextEmail.getText().toString().equals(data.email) && editTextPassword.getText().toString().equals(data.password)){
                    Toast.makeText(Activity4.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Activity4.this, Activity5.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Activity4.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
                /*String userEmail = editTextEmail.getText().toString().trim();
                String userPassword = editTextPassword.getText().toString().trim();
                if (!userEmail.isEmpty() || !userPassword.isEmpty()) {
                    login(userEmail, userPassword);
                } else {
                    editTextEmail.setError("Please insert email");
                    editTextPassword.setError("Please insert password");
                }*/
            }
        });
    }

    /*private void login(final String editTextEmail, final String editTextPassword) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, loginUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");
                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String firstName = object.getString("Firstname").trim();
                            String lastName = object.getString("Lastname").trim();
                            result.declareOutput(firstName, lastName);
                            Intent intent = new Intent(Activity4.this, Activity5.class);
                            intent.putExtra("Firstname", firstName);
                            intent.putExtra("Lastname", lastName);
                            Toast.makeText(Activity4.this, "Success", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                    }else{
                        Toast.makeText(Activity4.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                    Toast.makeText(Activity4.this, "Error" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Activity4.this, "Error" + error.toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("Email", editTextEmail);
                params.put("Pass", editTextPassword);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }*/
}