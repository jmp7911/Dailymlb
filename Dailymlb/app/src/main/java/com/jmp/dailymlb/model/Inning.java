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
}
