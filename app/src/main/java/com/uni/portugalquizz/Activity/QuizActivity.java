package com.uni.portugalquizz.Activity;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import com.uni.portugalquizz.Classes.Player;
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
    private TextView txtScore;
    private ImageView answer;
    private ImageView done;
    AnimatedVectorDrawableCompat avd;
    AnimatedVectorDrawable avd2;
    private Player player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        player = (Player) getIntent().getSerializableExtra("player");

        setContentView(R.layout.activity_quizz);
        answer = findViewById(R.id.circle);
        done = findViewById(R.id.imageView3);
        txtQuestion = findViewById(R.id.txtQuestion);
        txtScore = findViewById(R.id.lblScore);
        bA = findViewById(R.id.btnA);
        bB = findViewById(R.id.btnB);
        bD = findViewById(R.id.btnD);
        bC = findViewById(R.id.btnC);

        questionDAO = new QuestionDAO(this);
        getQuestion();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnA:
                answerIsCorrect(txtQuestion.getText().toString(), bA.getText().toString());
                //Toast.makeText(QuizActivity.this, "button1", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnB:
                answerIsCorrect(txtQuestion.getText().toString(), bB.getText().toString());
                //Toast.makeText(QuizActivity.this, "button2", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnC:
                answerIsCorrect(txtQuestion.getText().toString(), bC.getText().toString());
                // Toast.makeText(QuizActivity.this, "button3", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnD:
                answerIsCorrect(txtQuestion.getText().toString(), bD.getText().toString());
                //Toast.makeText(QuizActivity.this, "button d", Toast.LENGTH_LONG).show();
                break;


        }
    }


    public Question getQuestion() {
        Question question = questionDAO.getQuestion();
        txtQuestion.setText(question.getName_question());
        bA.setText(question.getAnswers().get(0).getName_Answer());
        bB.setText(question.getAnswers().get(1).getName_Answer());
        bC.setText(question.getAnswers().get(2).getName_Answer());
        bD.setText(question.getAnswers().get(3).getName_Answer());
        return question;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public boolean answerIsCorrect(String question, String answer) {

        if (questionDAO.answerIsCorrect(question, answer)) {
            player.correctAnswer();
            txtScore.setText("Score:" + player.getScore());
            Toast.makeText(QuizActivity.this, "is correct", Toast.LENGTH_SHORT).show();
            //showAnimation();
            Intent i = new Intent(this, QuizActivity.class);
            startActivity(i);
            return true;

        } else {
            Toast.makeText(QuizActivity.this, "is incorrect", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, QuizActivity.class);
            startActivity(i);
            return false;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showAnimation(){
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        Drawable draw = done.getDrawable();

        if(draw instanceof AnimatedVectorDrawableCompat){
            avd = (AnimatedVectorDrawableCompat) draw;
            avd.start();
        }
        else if(draw instanceof  AnimatedVectorDrawable) {
            avd2 = (AnimatedVectorDrawable) draw;
            avd2.start();
        }
    }


}
