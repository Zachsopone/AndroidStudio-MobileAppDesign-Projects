package com.example.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import java.util.Random;

public class Guess extends Fragment implements View.OnClickListener{

    private SharedViewModel viewModel;
    Button button;
    EditText editTextName;
    private int correctNumber;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guess, container, false);
        editTextName = v.findViewById(R.id.editTextName);
        button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft= getParentFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentGuess, new Result());
                ft.commit();
                if (v == button) {
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
            button=v.findViewById(R.id.button);
            v.setOnClickListener(this);
        }
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);
    }

    @Override
    public void onClick(View view) {

    }
}