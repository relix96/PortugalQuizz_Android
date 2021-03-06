package com.uni.portugalquizz.Services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.uni.portugalquizz.Classes.Player;
import com.uni.portugalquizz.DAO.PlayerDAO;


public class PlayerService extends SQLiteOpenHelper {

    private static final String name = "portuguese_quiz.db";
    private static final int version = 1;
    //private PlayerDAO playerDAO;


    public PlayerService(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table player(id integer primary key autoincrement," + "name varchar(30), score integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert("player", null, values);
        return result;
    }

    public void updatePlayer(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        db.update("player",values,"update player set score = ?  where id_player=?", new String[]{String.valueOf(values.get("score")),String.valueOf(values.get("id_player"))});
        //db.execSQL("update player set score = "+player.getScore()+" where id_player="+player.getId(),null);
    }

    public Cursor top10(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select player.name_player, player.score from player order by player.score desc limit 10",null);
        return res;
    }
}
