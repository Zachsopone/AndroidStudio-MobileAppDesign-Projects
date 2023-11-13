package com.example.challenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public static final String Extra1="com.example.challenge2.example.Celsius";
    public static final String Extra2="com.example.challenge2.example.Fahrenheit";
    RadioButton radioButton1, radioButton2;
    RadioGroup radioGroup;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton1=findViewById(R.id.radioButton1);
        radioButton2=findViewById(R.id.radioButton2);
        button1=findViewById(R.id.button1);
        radioGroup=findViewById(R.id.radioGroup1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkButton();
            }
        });
    }
    public void checkButton(){
        if (radioButton1.isChecked()) {
            String rad1 = radioButton1.getText().toString();
            Intent intent1=new Intent(this,Activity1.class);
            intent1.putExtra(Extra1, rad1);
            startActivity(intent1);
        } else if(radioButton2.isChecked()){
            String rad2= radioButton2.getText().toString();
            Intent intent=new Intent(this,Activity2.class);
            intent.putExtra(Extra2, rad2);
            startActivity(intent);
        }
    }
}