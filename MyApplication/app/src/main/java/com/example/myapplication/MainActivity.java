package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText1= findViewById(R.id.editText1);
        final EditText editText2= findViewById(R.id.editText2);
        final EditText editText6= findViewById(R.id.editText6);
        final EditText editText4= findViewById(R.id.editText4);
        final EditText editText7= findViewById(R.id.editText7);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText1.getText().toString();
                String text1 = editText2.getText().toString();
                String text6 = editText6.getText().toString();
                String text4 = editText4.getText().toString();
                String text7 = editText7.getText().toString();
                Intent intent = new Intent(MainActivity.this, Activity3.class);
                intent.putExtra("First name", text);
                intent.putExtra("Last name", text1);
                intent.putExtra("Birth date", text6);
                intent.putExtra("Email address", text4);
                intent.putExtra("Password", text7);
                startActivity(intent);
            }
        });
    }
}