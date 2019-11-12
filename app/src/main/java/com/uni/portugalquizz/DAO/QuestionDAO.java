package com.uni.portugalquizz.DAO;

import android.content.Context;
import android.database.Cursor;

import com.uni.portugalquizz.Classes.Question;
import com.uni.portugalquizz.Services.QuestionService;

public class QuestionDAO {

    Question question;
    QuestionService questionService;

    public QuestionDAO(Context context) {
        questionService = new QuestionService(context);
    }

    public Cursor getQuestion(){
        Cursor res = questionService.getQuestion();
        return res;
    }


}
