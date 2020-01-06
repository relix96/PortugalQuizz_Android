package com.uni.portugalquizz.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.uni.portugalquizz.Classes.Player;
import com.uni.portugalquizz.Services.PlayerService;

import java.util.ArrayList;

public class PlayerDAO {
    PlayerService playerService;
    Player player;

    public PlayerDAO(Context context) {
        playerService = new PlayerService(context);
    }


    public long InsertPlayer(Player player) {
        ContentValues values = new ContentValues();
        values.put("name_player", player.getName());
        values.put("score", player.getScore());
        return playerService.insertData(values);
    }

    public void updatePlayer(Player player){
        ContentValues values = new ContentValues();
        values.put("id_player", player.getId());
        values.put("score", player.getScore());
        playerService.updatePlayer(values);
    }

    public ArrayList<String> top10(){
        ArrayList players = new ArrayList();

        Cursor res = playerService.top10();

        while(res.moveToNext()){
            players.add(res.getString(0)+" - " +res.getInt(1));
        }

        return players;
    }

}
