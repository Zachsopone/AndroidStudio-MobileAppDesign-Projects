package com.example.activity5;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BMI extends AppCompatActivity {
    EditText weight, feet, inches;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        weight = findViewById(R.id.editTextWeight);
        feet = findViewById(R.id.editTextHeight);
        inches = findViewById(R.id.editTextHeight1);
        result = findViewById(R.id.BMI);

    }

    public void calculate(View view) {
        String stringWeight=weight.getText().toString();
        String stringInches=inches.getText().toString();
        String stringFeet=feet.getText().toString();
        float Weight = Float.parseFloat(stringWeight);
        float Inches = Float.parseFloat(stringInches);
        float Feet = Float.parseFloat(stringFeet);
        float inch = (Feet * 12) + Inches;
        double BMI = (Weight / (inch * inch)) * 703;
        DecimalFormat decimalFormat=new DecimalFormat("##.#");
        double bmi= Double.parseDouble(decimalFormat.format(BMI));
        if (bmi < 18.4) {
            result.setText("You are Underweight");
        } else if (bmi <= 24.9 && bmi >= 18.5) {
            result.setText("You have Normal weight");
        } else if (bmi <= 39.9 && bmi >= 25.0) {
            result.setText("You are Overweight");
        } else if(bmi >= 40.0){
            result.setText("You are Obese");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent b = new Intent(this, BMI.class);
                startActivity(b);
                return true;
            case R.id.item2:
                Intent c = new Intent(this, Converter.class);
                startActivity(c);
                return true;
            case R.id.item3:
                Intent d = new Intent(this, MainActivity.class);
                startActivity(d);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}