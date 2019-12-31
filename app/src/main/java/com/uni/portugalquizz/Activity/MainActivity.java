package com.uni.portugalquizz.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.uni.portugalquizz.DAO.PlayerDAO;
import com.uni.portugalquizz.R;


public class MainActivity extends AppCompatActivity {

    PlayerDAO playerDAO;
    private Button btnPlay;
    private Button btnScore;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        btnScore = findViewById(R.id.btnScores);
        btnExit = findViewById(R.id.btnExit);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
    }


    public void exitApp(View v){
        finish();
    }

    public void play() {
        Intent intent = new Intent(this, PlayerScore.class);
        startActivity(intent);
    }
}


