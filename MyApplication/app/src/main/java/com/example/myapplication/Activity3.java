package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    Button button2,button1;
    TextView textView7, textView8, textView9, textView10,textView18;
    /*private static String url="http://192.168.18.39:80/index/register.php";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView18 = (TextView) findViewById(R.id.textView18);

        Intent intent =getIntent();
        String text = intent.getStringExtra("First name");
        String text1 = intent.getStringExtra("Last name");
        String text6 = intent.getStringExtra("Birth date");
        String text4 = intent.getStringExtra("Email address");
        String text7 = intent.getStringExtra("Password");
        TextView resultText = findViewById(R.id.textView7);
        TextView resultTex = findViewById(R.id.textView8);
        TextView result = findViewById(R.id.textView9);
        TextView res = findViewById(R.id.textView10);
        TextView re = findViewById(R.id.textView18);


        resultText.setText(text);
        resultTex.setText(text1);
        result.setText(text6);
        res.setText(text4);
        re.setText(text7);

        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            /*Reg();*/
            openActivity4();
            }
        });
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                /*Reg();*/
                openMainActivity();
            }
        });
    }
    public void openActivity4() {
        data.firstname=textView7.getText().toString();
        data.lastname=textView8.getText().toString();
        data.birthdate=textView9.getText().toString();
        data.email=textView10.getText().toString();
        data.password=textView18.getText().toString();
        Toast.makeText(Activity3.this, "Information Saved", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Activity3.this,Activity4.class));
    }

    public void openMainActivity(){
        startActivity(new Intent(Activity3.this,MainActivity.class));
    }

    /*private void Reg(){
        final String fname=this.textView7.getText().toString().trim();
        final String lname=this.textView8.getText().toString().trim();
        final String bdate=this.textView9.getText().toString().trim();
        final String email=this.textView10.getText().toString().trim();
        final String password=this.textView18.getText().toString().trim();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                    String success = jsonObject.getString("success");
                    if(success.equals("1")){
                        Toast.makeText(Activity3.this,"Register Success!", Toast.LENGTH_SHORT).show();
                    }
                }catch(JSONException e){
                    e.printStackTrace();
                    Toast.makeText(Activity3.this,"Register Failed"+e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Activity3.this,"Register Failed"+error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String, String>();
                map.put("Firstname",fname);
                map.put("Lastname",lname);
                map.put("Birthdate",bdate);
                map.put("Email",email);
                map.put("Pass",password);
                return map;
            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }*/
}