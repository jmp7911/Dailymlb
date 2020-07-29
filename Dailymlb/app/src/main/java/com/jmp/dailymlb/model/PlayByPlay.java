package com.jmp.dailymlb.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PlayByPlay {
    @SerializedName("Game")
    Game game;
    @SerializedName("Plays")
    ArrayList<Play> plays;

    public Game getGame() {
        return game;
    }

    public ArrayList<Play> getPlays() {
        return plays;
    }

}
