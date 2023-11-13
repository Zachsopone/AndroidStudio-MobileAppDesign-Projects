package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.Random;

public class FirstFragment extends Fragment implements View.OnClickListener{

    private SharedViewModel viewModel;
    Button button2;
    EditText editTextName;
    private int correctNumber;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        editTextName = v.findViewById(R.id.editTextName);
        button2 = v.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == button2) {
                    buttons();
                }
            }
        });
        return v;
    }
    private void buttons() {
        int num=Integer.parseInt(editTextName.getText().toString());
        Random rand=new Random();
        correctNumber=rand.nextInt(12)+1;
        if(num==correctNumber) {
            viewModel.setText(editTextName.getText());
        }else{
            editTextName= v.findViewById(R.id.editTextName);
            button2=v.findViewById(R.id.button2);
            v.setOnClickListener(this);
        }
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);
        /*viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(CharSequence charSequence) {
                editTextName.setText(charSequence);
            }
        });*/
    }

    @Override
    public void onClick(View view) {

    }
}