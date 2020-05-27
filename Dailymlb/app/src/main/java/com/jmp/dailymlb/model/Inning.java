package com.jmp.dailymlb.model;

import com.google.gson.annotations.SerializedName;

public class Inning {
    @SerializedName("GameID")
    int gameId;
    @SerializedName("InningID")
    int inningId;
    @SerializedName("InningNumber")
    int inningNumber;
    @SerializedName("AwayTeamRuns")
    int awayTeamRuns;
    @SerializedName("HomeTeamRuns")
    int homeTeamRuns;

    public int getGameId() {
        return gameId;
    }

    public int getInningId() {
        return inningId;
    }

    public int getInningNumber() {
        return inningNumber;
    }

    public int getAwayTeamRuns() {
        return awayTeamRuns;
    }

    public int getHomeTeamRuns() {
        return homeTeamRuns;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setInningId(int inningId) {
        this.inningId = inningId;
    }

    public void setInningNumber(int inningNumber) {
        this.inningNumber = inningNumber;
    }

    public void setAwayTeamRuns(int awayTeamRuns) {
        this.awayTeamRuns = awayTeamRuns;
    }

    public void setHomeTeamRuns(int homeTeamRuns) {
        this.homeTeamRuns = homeTeamRuns;
    }
}

