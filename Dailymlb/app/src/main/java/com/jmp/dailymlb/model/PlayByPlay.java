package com.jmp.dailymlb.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PlayByPlay {
    @SerializedName("Game")
    GameScore game;
    @SerializedName("Plays")
    ArrayList<Play> plays;

    public GameScore getGame() {
        return game;
    }

    public void setGame(GameScore game) {
        this.game = game;
    }

    public ArrayList<Play> getPlays() {
        return plays;
    }

    public void setPlays(ArrayList<Play> plays) {
        this.plays = plays;
    }
}
