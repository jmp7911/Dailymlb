package com.jmp.dailymlb.model;

import com.google.gson.annotations.SerializedName;

public class TeamStat {
    @SerializedName("StatID")
    int statId;
    @SerializedName("SeasonType")
    int seasonType;
    @SerializedName("Season")
    int season;
    @SerializedName("Name")
    String name;
    @SerializedName("Team")
    String team;
    @SerializedName("Updated")
    String updated;
    @SerializedName("Games")
    int games;
    @SerializedName("Wins")
    float wins;
    @SerializedName("Losses")
    float losses;

    public int getStatId() {
        return statId;
    }

    public int getSeasonType() {
        return seasonType;
    }

    public int getSeason() {
        return season;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getUpdated() {
        return updated;
    }

    public int getGames() {
        return games;
    }

    public float getWins() {
        return wins;
    }

    public float getLosses() {
        return losses;
    }
}
