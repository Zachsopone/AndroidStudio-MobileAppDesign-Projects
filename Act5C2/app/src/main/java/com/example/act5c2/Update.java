package com.example.act5c2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {
    Button button5;
    EditText editTextTextPersonName2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        button5=findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                open();
                Intent intent=getIntent();
                String update=intent.getStringExtra("CarName");
                editTextTextPersonName2.setText(update);

            }
        });
    }
    public void open(){
        startActivity(new Intent(Update.this,Cars.class));
    }
}