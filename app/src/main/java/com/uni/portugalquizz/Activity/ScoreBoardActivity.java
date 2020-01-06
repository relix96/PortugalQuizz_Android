package com.uni.portugalquizz.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.uni.portugalquizz.DAO.PlayerDAO;
import com.uni.portugalquizz.R;

import java.util.ArrayList;


public class ScoreBoardActivity extends AppCompatActivity {

    private ListView lsvScore;
    private TextView txt1;
    private ArrayAdapter<String> adapter;
    private PlayerDAO playerDAO;
    private ArrayList<String> players ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        playerDAO = new PlayerDAO(this);
        players = playerDAO.top10();
        lsvScore = findViewById(R.id.lsvScores);
        txt1 = findViewById(R.id.text1);
        adapter = new ArrayAdapter<String>(this,R.layout.activity_score_board,R.id.text1,players);
        //make a ListView to show the top 10
        lsvScore.setAdapter(adapter);
    }
}
