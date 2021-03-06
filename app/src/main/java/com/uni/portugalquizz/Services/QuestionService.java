package com.uni.portugalquizz.Services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.uni.portugalquizz.Classes.Player;
import com.uni.portugalquizz.Classes.Question;
import com.uni.portugalquizz.DAO.QuestionDAO;

public class QuestionService extends SQLiteOpenHelper {

    private static final String name = "portuguese_quiz.db";
    private static final int version = 1;
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

    public Cursor getQuestion() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from question", null);
        return res;
    }

    public Cursor answerIsCorrect(String question, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select question.name_question, Answer.name_answer,question_answer.isCorrect from question inner join question_answer on question_answer.id_question = question.id_question inner join Answer on Answer.id_answer = question_answer.id_answer WHERE question.name_question = ? and Answer.name_answer= ?", new String[]{question, answer});
        return res;
    }

    public Cursor getAnswers(Question question) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT answer.id_answer,Answer.name_answer, question_answer.isCorrect from Answer inner join question_answer on question_answer.id_answer= Answer.id_answer INNER join question on question_answer.id_question = question.id_question where question.id_question= ?", new String[]{String.valueOf(question.getId())});
        return res;
    }


    // check if the questions was already asked
    public Cursor checkQuestions(Player player, Question question){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT question.name_question, player.id_player from question inner join player_question on player_question.id_question= question.id_question INNER join player on player_question.id_player = player.id_player where player.id_player = ? and question.id_question = ?",new String[]{String.valueOf(player.getId()),String.valueOf(question.getId())});
        return res;
    }

    public long insertPlayerQuestions(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert("player_question", null, values);
        return result;
    }

    public Cursor countQuestions() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT question.id, question.name_question from question",null);
        return res;
    }


}
