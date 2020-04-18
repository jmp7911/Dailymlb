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

    public void setStatId(int statId) {
        this.statId = statId;
    }

    public int getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(int seasonType) {
        this.seasonType = seasonType;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public float getWins() {
        return wins;
    }

    public void setWins(float wins) {
        this.wins = wins;
    }

    public float getLosses() {
        return losses;
    }

    public void setLosses(float losses) {
        this.losses = losses;
    }
}
