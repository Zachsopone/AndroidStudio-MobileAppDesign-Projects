package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity5 extends AppCompatActivity {

    private TextView textView19;
    private Button button4;
    /*Output result;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        /*result=new Output(this);
        result.loadLogin();*/

        textView19 = findViewById(R.id.textView19);
        textView19.setText(data.firstname + " " + data.lastname);
        button4 = findViewById(R.id.button4);

        /*HashMap<String, String> data=result.getData();
        String fName=data.get(result.fname);
        String lName=data.get(result.lname);
        textView19.setText(fName +" "+ lName);*/

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*result.logout();*/
                openMainActivity();
            }
        });
    }
    public void openMainActivity() {
        Intent intent = new Intent(Activity5.this, MainActivity.class);
        startActivity(intent);
    }
}