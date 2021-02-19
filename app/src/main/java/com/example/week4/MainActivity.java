package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView leftDice= findViewById(R.id.left);
        ImageView rightDice= findViewById(R.id.right);
        Button higher_btn = findViewById(R.id.higher_button);
        Button lower_btn = findViewById(R.id.lower_button);
        Random rd = new Random();
        TextView msg = findViewById(R.id.message);

        int [] dice_array = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6,
        };

        higher_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                int rand_left = rd.nextInt(6);
                int rand_right = rd.nextInt(6);
                Log.d("left dice", String.valueOf(rand_left));
                Log.d("right dice", String.valueOf(rand_right));

                leftDice.setImageResource(dice_array[rand_left]);
                rightDice.setImageResource(dice_array[rand_right]);

                if(rand_left > rand_right){
                    msg.setText("User Win");
                }else{
                    if(rand_left < rand_right){
                        msg.setText("Computer  Win");
                    }else{
                        msg.setText("It’s a tie");
                    }
                }
            }
        });

        lower_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int rand_left = rd.nextInt(6);
                int rand_right = rd.nextInt(6);
                Log.d("left dice", String.valueOf(rand_left));
                Log.d("right dice", String.valueOf(rand_right));

                leftDice.setImageResource(dice_array[rand_left]);
                rightDice.setImageResource(dice_array[rand_right]);

                if(rand_left < rand_right){
                    msg.setText(R.string.result1);
                }else{
                    if(rand_left > rand_right){
                        msg.setText(R.string.result2);
                    }else{
                        msg.setText(R.string.result3);
                    }
                }
            }
        });



    }
}