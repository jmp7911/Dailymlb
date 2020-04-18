package com.jmp.dailymlb.model;

import com.google.gson.annotations.SerializedName;

public class Inning {
    @SerializedName("InningID")
    int inningId;
    @SerializedName("InningNumber")
    int inningNumber;
    @SerializedName("AwayTeamRuns")
    int awayTeamRuns;
    @SerializedName("HomeTeamRuns")
    int homeTeamRuns;
    @SerializedName("GameID")
    int gameId;
}
