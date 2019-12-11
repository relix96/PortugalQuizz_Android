package com.uni.portugalquizz.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.uni.portugalquizz.Classes.Answer;
import com.uni.portugalquizz.Classes.Question;
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

        ArrayList<Integer> questionsId = new ArrayList<>();

        txtQuestion = findViewById(R.id.txtQuestion);
        bA = findViewById(R.id.btnA);
        bB = findViewById(R.id.btnB);
        bD = findViewById(R.id.btnD);
        bC = findViewById(R.id.btnC);

        questionDAO = new QuestionDAO(this);

        Question question = getQuestion(questionsId);
        questionsId.add((int)question.getId());

    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnA:
                answerIsCorrect(txtQuestion.getText().toString(),bA.getText().toString());
                //Toast.makeText(QuizActivity.this, "button1", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnB:
                answerIsCorrect(txtQuestion.getText().toString(),bB.getText().toString());
                //Toast.makeText(QuizActivity.this, "button2", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnC:
                answerIsCorrect(txtQuestion.getText().toString(),bC.getText().toString());
               // Toast.makeText(QuizActivity.this, "button3", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnD:
                answerIsCorrect(txtQuestion.getText().toString(),bD.getText().toString());
                //Toast.makeText(QuizActivity.this, "button d", Toast.LENGTH_LONG).show();
                break;


        }
    }


    public Question getQuestion(ArrayList questionsId) {
        Question question = questionDAO.getQuestion(questionsId);
        txtQuestion.setText(question.getName_question());
        bA.setText(question.getAnswers().get(0).getName_Answer());
        bB.setText(question.getAnswers().get(1).getName_Answer());
        bC.setText(question.getAnswers().get(2).getName_Answer());
        bD.setText(question.getAnswers().get(3).getName_Answer());
        return question;
    }

    public boolean answerIsCorrect(String question, String answer) {
        if (questionDAO.answerIsCorrect(question, answer)) {
            Toast.makeText(QuizActivity.this, "is correct", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this,QuizActivity.class);
            startActivity(i);
            return true;

        }
        else{
            Toast.makeText(QuizActivity.this, "is incorrect", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this,QuizActivity.class);
            startActivity(i);
            return false;
        }
    }


}
