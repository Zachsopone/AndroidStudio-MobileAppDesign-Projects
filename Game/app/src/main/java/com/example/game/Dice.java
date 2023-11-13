package com.example.game;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Dice {
    int sleepTime = 10;
    int roll = 10;
    int[] diceImages = new int[]{R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
    Random rand = new Random();
    TextView result;
    LinearLayout linearLayout;
    void rollDice(ImageView img1,ImageView img2) {
        for (int i = 0; i <= roll; i++) {
            int diceValue1 = rand.nextInt(6) + 1;
            int diceValue2 = rand.nextInt(6) + 1;
            img1.setImageResource(diceImages[diceValue1 - 1]);
            img2.setImageResource(diceImages[diceValue2 - 1]);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread thread = new Thread();
        thread.start();
    }
}
