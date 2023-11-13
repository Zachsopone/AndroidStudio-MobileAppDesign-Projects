package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {
    FrameLayout context_a;
    FrameLayout context_b;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context_a=(FrameLayout)findViewById(R.id.container_a);
        context_b=(FrameLayout)findViewById(R.id.container_b);
        FirstFragment firstFragment=new FirstFragment();
        SecondFragment secondFragment=new SecondFragment();
        fragmentManager=getSupportFragmentManager();
        transaction=fragmentManager.beginTransaction();
        transaction.addToBackStack(null);
        transaction.add(R.id.container_a, firstFragment).add(R.id.container_b,secondFragment).commit();

    }
}