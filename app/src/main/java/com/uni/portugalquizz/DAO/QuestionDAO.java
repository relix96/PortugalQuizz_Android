package com.uni.portugalquizz.DAO;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.uni.portugalquizz.Classes.Answer;
import com.uni.portugalquizz.Classes.Question;
import com.uni.portugalquizz.Services.QuestionService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuestionDAO {

    QuestionService questionService;

    public QuestionDAO(Context context) {
        questionService = new QuestionService(context);
    }

    public Question getQuestion(ArrayList questionsId) {
        Question question = new Question();
        List<Answer> answers;
        Cursor res = questionService.getQuestion();
        int idx = 0;
        boolean aux = true;
        if (res.getCount() == 0)
            return null;
        else {
            int q = random(res.getCount());
            //int q=2;
            while (aux) {
                aux = false;
                while (res.moveToNext()) {
                    question.setId(res.getInt(0));
                    question.setName_question(res.getString(1));
                    answers = getAnswers(question);
                    question.setAnswers(answers);
                    if (idx == q) {
                        if (questionsId.contains(res.getInt(0))) {
                            aux = true;
                            break;
                        } else
                            return question;
                    } else
                        idx++;
                }

            }
            return null;
        }

    }


    public boolean answerIsCorrect(String question, String answer) {
        Cursor res = questionService.answerIsCorrect(question, answer);
        System.out.println("Value: "+res.getCount());
        while(res.moveToNext()) {

            if (res.getInt(2) == 0 || res.getCount() == 0)
                return false;
            else
                return true;
        }
        return false;
    }

    public int random(int max) {
        int min = 0;
        int random = new Random().nextInt((max - min) + 1) + min;
        return random;
    }

    public ArrayList getAnswers(Question question) {
        ArrayList<Answer> answers = new ArrayList();
        Cursor res = questionService.getAnswers(question);
        System.out.print(res.getCount());
        while (res.moveToNext()) {
            Answer answer = new Answer();
            answer.setId_Answer(res.getInt(0));
            answer.setName_Answer(res.getString(1));
            answer.setIdCorrect(res.getInt(2));
            answers.add(answer);
        }
        Collections.shuffle(answers);
        /*while(answers.get(0).isCorrect() == 0 && answers.get(1).isCorrect() == 0 && answers.get(2).isCorrect() == 0 && answers.get(3).isCorrect() == 0){
            Collections.shuffle(answers);
        }*/
        answers= verifyCorrectAnswer(answers);
        return answers;
    }

    private ArrayList verifyCorrectAnswer(ArrayList<Answer> answers) {
        while (answers.get(0).isCorrect() == 0 && answers.get(1).isCorrect() == 0 && answers.get(2).isCorrect() == 0 && answers.get(3).isCorrect() == 0) {
            Collections.shuffle(answers);
        }
        return answers;
    }
}
