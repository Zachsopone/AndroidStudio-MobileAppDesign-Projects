package com.example.act5c2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button button, button2;
    EditText editText1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1=findViewById(R.id.editTextTextPersonName);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String stringName=editText1.getText().toString();
                Toast.makeText(MainActivity.this, "Data added Successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Cars.class);
                intent.putExtra("CarName",stringName);
                startActivity(intent);
            }
        });
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });
    }
    public void openActivity(){
        startActivity(new Intent(MainActivity.this,Cars.class));
    }

}