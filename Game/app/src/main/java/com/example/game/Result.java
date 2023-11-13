package com.example.game;


import android.media.MediaPlayer;
import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Result extends Fragment {
    private Dice dice;
    ImageView image1, image2;
    LinearLayout linearLayout1;
    MediaPlayer mp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_result,container,false);
        image1=v.findViewById(R.id.img_a);
        image2=v.findViewById(R.id.img_b);
        linearLayout1=v.findViewById(R.id.linearLayout);
        linearLayout1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try{
                    dice.rollDice(image1,image2);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        dice=new Dice();
    }

}
