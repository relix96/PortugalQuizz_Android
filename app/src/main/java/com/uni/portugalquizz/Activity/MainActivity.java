package com.uni.portugalquizz.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.uni.portugalquizz.Classes.Player;
import com.uni.portugalquizz.DAO.PlayerDAO;
import com.uni.portugalquizz.R;


public class MainActivity extends AppCompatActivity {

    private EditText name;
    Button btnPlay;
    PlayerDAO playerDAO;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Integer  score=0;
        name = (EditText)findViewById(R.id.txtNamePlayer);
        btnPlay = (Button)findViewById(R.id.btnPlay);
        playerDAO = new PlayerDAO(this);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player player = new Player();
                player.setName(name.getText().toString());
                player.setScore(score);
                System.out.print(player.toString());
                long id = playerDAO.InsertPlayer(player);
                player.setId(id);

                    Toast.makeText(MainActivity.this,"Button clicked:"+player.getName()+"|"+id,Toast.LENGTH_SHORT).show();






            }
        });
    }








}


