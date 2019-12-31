package com.uni.portugalquizz.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.uni.portugalquizz.R;
import com.uni.portugalquizz.Classes.*;
import com.uni.portugalquizz.DAO.PlayerDAO;

import android.os.Bundle;

public class PlayerScore extends AppCompatActivity {
    PlayerDAO playerDAO;
    private EditText namePlayer;
    private int score=0;

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
        if(namePlayer.getText().toString()!="") {
            Player player = new Player();
            player.setName(namePlayer.getText().toString());
            player.setScore(score);
            System.out.print(player.toString());
            long id = playerDAO.InsertPlayer(player);
            player.setId(id);
            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("player",player);
            startActivity(intent);
        }
    }
}
