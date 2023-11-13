package com.example.challenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView textView4, textView6;
    EditText editText2;
    Button button3, button4;
    double c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent1 = getIntent();
        String radio2=intent1.getStringExtra(MainActivity.Extra2);
        textView4=findViewById(R.id.textView4);
        textView4.setText(radio2);
        editText2=findViewById(R.id.editText2);
        textView6=findViewById(R.id.textView6);
        button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertFahrenheit();
            }
        });
        button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainAct();
            }
        });
    }
    public void openMainAct(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void convertFahrenheit(){
        double x=Double.parseDouble(String.valueOf(editText2.getText()));
        c=(x*9/5)+32;
        String b = String.format("%.2f",c);
        textView6.setText(b);
    }
}