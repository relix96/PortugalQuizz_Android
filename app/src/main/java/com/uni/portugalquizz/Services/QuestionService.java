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

        /*db.execSQL("create table player(id_player integer primary key autoincrement,"+"name_player varchar(30), score integer)");
        db.execSQL("create table question(id_question integer primary key autoincrement,"+"name_question varchar(50))");
        db.execSQL("create table Answer(id_answer integer primary key autoincrement,"+"name_answer varchar(30))");
        db.execSQL("create table player_question(id_player integer references player(id_player),id_question integer primary key references Question(id_question))");
        db.execSQL("create table question_answer(id_question integer references Question(id_question),id_answer integer primary key references Answer(id_answer))");
*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getQuestion(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from question",null);
        return res;
    }

    public Cursor questionIsCorrect(String question, String answer){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select "+question+" from question",null);
        return res;
    }

    public Cursor getAnswers(String question){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select question."+question+" from question",null);
        return res;
    }
}
