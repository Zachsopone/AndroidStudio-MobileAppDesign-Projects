package com.example.challenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    TextView textView1, textView3;
    EditText editText1;
    Button button1, button2;
    double f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Intent intent = getIntent();

        String radio1=intent.getStringExtra(MainActivity.Extra1);

        textView1=findViewById(R.id.textView1);
        textView1.setText(radio1);
        editText1=findViewById(R.id.editText1);
        textView3=findViewById(R.id.textView3);
        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCelsius();
            }
        });
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
    }
    public void openMainActivity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void convertCelsius(){
        double x=Double.parseDouble(String.valueOf(editText1.getText()));
        f=(x-32)*5/9;
        String b = String.format("%.2f",f);
        textView3.setText(b);
    }
}