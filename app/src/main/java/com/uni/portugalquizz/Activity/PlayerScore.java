package com.uni.portugalquizz.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.uni.portugalquizz.R;
import com.uni.portugalquizz.Classes.*;
import com.uni.portugalquizz.DAO.PlayerDAO;

import android.os.Bundle;
import android.widget.Toast;

public class PlayerScore extends AppCompatActivity {
    PlayerDAO playerDAO;
    private EditText namePlayer;
    private int score=0;
    private String name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_score);
        playerDAO = new PlayerDAO(this);
        namePlayer =  findViewById(R.id.txtPlayerName);

    }

    public void goToMenu(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickPlay(View v) {
        name=namePlayer.getText().toString();
        if(!name.isEmpty()) {
            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("name",name);
            startActivity(intent);
        }
        else{
            Toast.makeText(PlayerScore.this, "Plese insert your name.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isEmpty(String s){
        if(s.isEmpty())
            return true;
        else
            return false;
    }
}
