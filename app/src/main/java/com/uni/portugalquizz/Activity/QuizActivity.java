package com.uni.portugalquizz.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.uni.portugalquizz.DAO.QuestionDAO;
import com.uni.portugalquizz.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private QuestionDAO questionDAO;
    private TextView txtQuestion;
    private Button bA;
    private Button bB;
    private Button bC;
    private Button bD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        txtQuestion = findViewById(R.id.txtQuestion);
        bA = findViewById(R.id.btnA);
        bB = findViewById(R.id.btnB);
        bD = findViewById(R.id.btnD);
        bC = findViewById(R.id.btnC);
        questionDAO = new QuestionDAO(this);

        getQuestion();
        for(int i = 0; i < 4; i++)
            getAnswers(i);
    }

    //put on the QuestionDAO
    //
    public void getQuestion(){
        int count = 0;
        List<String> questions = new ArrayList<>();
        Cursor res = questionDAO.getQuestion();
        if(res.getCount() == 0)
            return;
        else {
            while(res.moveToNext()){
                questions.add(res.getString(1));
                count++;
            }
            int idxQuestion = random(count);
            txtQuestion.setText(questions.get(idxQuestion));
        }
    }

    public int random(int max){
        int min=0;
        int random = new Random().nextInt((max - min) + 1) + min;
        return random;
    }

    public boolean questionIsCorrect(String question, String answer){
        if(question.equals(answer)){
            onCreate(new Bundle());
            return true;

        }
        return false;
    }

    public String getAnswers(int i){
        String answer="";
        switch (i) {
            case 0:break;
            case 1: break;
            case 2:break;
            case 4: break;
        }
        return answer;
    }
}
