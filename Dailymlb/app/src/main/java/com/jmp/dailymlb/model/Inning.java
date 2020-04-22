package com.jmp.dailymlb.model;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.Query;

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
}
