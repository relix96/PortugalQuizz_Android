package com.uni.portugalquizz.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.uni.portugalquizz.DAO.QuestionDAO;
import com.uni.portugalquizz.R;

import java.util.ArrayList;

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

        String question = getQuestion();
        getAnswers(question);

    }


    public String getQuestion(){
        String question = questionDAO.getQuestion();
        txtQuestion.setText(question);
        return question;
    }

    public boolean questionIsCorrect(String question, String answer){
        if(questionDAO.isCorrect(question,answer)){
            onCreate(new Bundle());
            return true;

        }
        onCreate(new Bundle());
        return false;
    }

    public void getAnswers(String question){
        ArrayList answers = questionDAO.getAnswers(question);
        bA.setText(answers.get(0).toString());
        bB.setText(answers.get(1).toString());
        bC.setText(answers.get(2).toString());
        bD.setText(answers.get(3).toString());
    }
}
