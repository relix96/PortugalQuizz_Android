package com.uni.portugalquizz.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
    private static  Player player;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        player = (Player) getIntent().getSerializableExtra("player");

        txtQuestion = findViewById(R.id.txtQuestion);
        txtScore = findViewById(R.id.lblScore);
        bA = findViewById(R.id.btnA);
        bB = findViewById(R.id.btnB);
        bD = findViewById(R.id.btnD);
        bC = findViewById(R.id.btnC);
        txtScore.setText("Score:" + player.getScore());
        questionDAO = new QuestionDAO(this);
        getQuestion();
    }


    public static void restartActivity(Activity act){

        Intent intent=new Intent();
        intent.setClass(act, act.getClass());
        intent.putExtra("player",player);
        act.startActivity(intent);
        //act.finish();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnA:
                answerIsCorrect(txtQuestion.getText().toString(), bA.getText().toString(),bA);
                //Toast.makeText(QuizActivity.this, "button1", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnB:
                answerIsCorrect(txtQuestion.getText().toString(), bB.getText().toString(),bB);
                //Toast.makeText(QuizActivity.this, "button2", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnC:
                answerIsCorrect(txtQuestion.getText().toString(), bC.getText().toString(), bC);
                // Toast.makeText(QuizActivity.this, "button3", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnD:
                answerIsCorrect(txtQuestion.getText().toString(), bD.getText().toString(),bD);
                //Toast.makeText(QuizActivity.this, "button d", Toast.LENGTH_LONG).show();
                break;


        }
    }


    public Question getQuestion() {
        Question question = questionDAO.getQuestion(player);
        txtQuestion.setText(question.getName_question());
        bA.setText(question.getAnswers().get(0).getName_Answer());
        bB.setText(question.getAnswers().get(1).getName_Answer());
        bC.setText(question.getAnswers().get(2).getName_Answer());
        bD.setText(question.getAnswers().get(3).getName_Answer());
        return question;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public boolean answerIsCorrect(String question, String answer, Button btn) {

        if (questionDAO.answerIsCorrect(question, answer)) {
            player.correctAnswer();
            txtScore.setText("Score:" + player.getScore());
            //questionDAO.insertAnswers(player,question);
            //Toast.makeText(QuizActivity.this, "is correct", Toast.LENGTH_SHORT).show();
            restartActivity(this);
            return true;

        } else {
           // Toast.makeText(QuizActivity.this, "is incorrect", Toast.LENGTH_SHORT).show();
            //Intent i = new Intent(this, QuizActivity.class);
            isIncorrect();

            return false;
        }
    }

    private void isIncorrect(){
        wrongAnswer();

    }

    public Dialog wrongAnswer() {
        final Intent  i = new Intent(this, PlayerScore.class);
        final Intent i2 = new Intent(this, MainActivity.class);
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("GAME OVER | YOUR SCORE IS:"+player.getScore())
                .setPositiveButton(R.string.menu, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(i2);
                    }
                })
                .setNegativeButton(R.string.play, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        startActivity(i);
                    }
                });
        // Create the AlertDialog object and return it
        builder.show();
        return builder.create();
    }

}
