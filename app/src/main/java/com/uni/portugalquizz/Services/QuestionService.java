package com.uni.portugalquizz.Services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.uni.portugalquizz.DAO.QuestionDAO;

import java.util.ArrayList;
import java.util.List;

public class QuestionService extends SQLiteOpenHelper {

    private static final String name="portuguese_quizz.db";
    private static final int version=1;
    private QuestionDAO questionDAO;

    public QuestionService(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("select * from question");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getQuestion(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from question",null);
        return res;
    }
}
