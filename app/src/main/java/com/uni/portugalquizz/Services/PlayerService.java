package com.uni.portugalquizz.Services;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.uni.portugalquizz.Classes.Player;
import com.uni.portugalquizz.DAO.PlayerDAO;


public class PlayerService extends SQLiteOpenHelper {

    private static final String name="portuguese_quizz.db";
    private static final int version=1;
    private PlayerDAO playerDAO;


    public PlayerService(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table player(id integer primary key autoincrement,"+"name varchar(30), score integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert("player",null,values);
        return result;
    }
}
