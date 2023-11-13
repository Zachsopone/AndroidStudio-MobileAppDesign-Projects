package com.example.act5c2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Cars extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    Button button3;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        Intent intent=getIntent();
        String cars=intent.getStringExtra("CarName");
        listView=(ListView) findViewById(R.id.listview);
        button3=findViewById(R.id.button3);
        arrayList=new ArrayList<String>();
        arrayList.add(cars);
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.example_menu,menu);
    }
    public void Remove(int position){
        arrayList.remove(position);
        arrayAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        ContextMenu.ContextMenuInfo i=item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.edit:
                int a = 0;
                String name= arrayAdapter.getItem(a).toString();
                Intent intent=new Intent(Cars.this,Update.class);
                intent.putExtra("CarName",name);
                startActivity(intent);
                return true;
            case R.id.delete:
                Remove(item.getGroupId());
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    public void back(){
        startActivity(new Intent(Cars.this,MainActivity.class));
    }
}