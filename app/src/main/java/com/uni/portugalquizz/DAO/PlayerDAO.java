package com.uni.portugalquizz.DAO;

import android.content.ContentValues;
import android.content.Context;

import com.uni.portugalquizz.Classes.Player;
import com.uni.portugalquizz.Services.PlayerService;

public class PlayerDAO {
    PlayerService playerService;
    Player player;

    public PlayerDAO(Context context) {
        playerService = new PlayerService(context);
    }


    public long InsertPlayer(Player player) {
        ContentValues values = new ContentValues();
        values.put("name", player.getName());
        values.put("score", player.getScore());
        return playerService.insertData(values);
    }

}
