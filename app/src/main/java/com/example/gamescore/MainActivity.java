package com.example.gamescore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int score1 = 0;
    private int score2 = 0;
    private TextView textViewScore1;
    private TextView textViewScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate");
        textViewScore1 = findViewById(R.id.score1);
        textViewScore2 = findViewById(R.id.score2);

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");
        }
//        textViewScore1.setText("" + score1);
        updateScore1();
        updateScore2();

        textViewScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score1++;
                updateScore1();
                Log.d("MainActivity", "Clicked textViewScore1. Score1: " + String.valueOf(score1));
            }
        });
        textViewScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score2++;
                updateScore2();
                Log.d("MainActivity", "Clicked textViewScore2. Score2: " + String.valueOf(score2));

            }
        });
    }
    @Override
    protected  void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onDestroy");
    }
    @Override
    protected  void onResume() {
        super.onResume();
        Log.d("MainActivity", "onDestroy");
    }
    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MainActivity", "onSaveInstanceState");

        outState.putInt("score1", score1);
        outState.putInt("score2", score2);
    }
    private void updateScore1(){
        textViewScore1.setText("" + score1);
    }
    private void updateScore2(){
        textViewScore2.setText("" + score2);
    }

}