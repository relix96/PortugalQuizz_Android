package com.uni.portugalquizz.DAO;

import android.content.Context;
import android.database.Cursor;

import com.uni.portugalquizz.Classes.Question;
import com.uni.portugalquizz.Services.QuestionService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuestionDAO {

    Question question;
    QuestionService questionService;

    public QuestionDAO(Context context) {
        questionService = new QuestionService(context);
    }

    public String getQuestion() {
        ArrayList idxQuestion = new ArrayList<>();
        List<String> questions = new ArrayList<>();
        Cursor res = questionService.getQuestion();

        if (res.getCount() == 0)
            return null;
        else {
            while (res.moveToNext()) {
                questions.add(res.getString(1));
            }
            int q = random(questions.size());
            for (int idx = 0; idx < idxQuestion.size();idx++) {
                if(idxQuestion.equals(idx)){
                    break;
                }
            }
            return questions.get(q);
        }
    }

    public boolean isCorrect(String question, String answer){
        Cursor res = questionService.questionIsCorrect(question, answer);
        if (res.getCount()==0)
            return false;
        else
            return true;
    }

    public int random(int max){
        int min=0;
        int random = new Random().nextInt((max - min) + 1) + min;
        return random;
    }

    public ArrayList getAnswers(String question){
        ArrayList answers = new ArrayList();
        int idx=0;
        Cursor res = questionService.getAnswers(question);
        while(idx < res.getCount()){
            answers.add(idx,res.getString(idx));
            idx++;
        }

        Collections.shuffle(answers);
        return answers;
    }




}
