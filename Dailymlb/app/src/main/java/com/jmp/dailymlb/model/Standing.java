package com.jmp.dailymlb.model;

import com.google.gson.annotations.SerializedName;

public class Standing {
    @SerializedName("Season")
    int season;
    @SerializedName("TeamID")
    int teamId;
    @SerializedName("Key")
    String key;
    @SerializedName("City")
    String city;
    @SerializedName("Name")
    String name;
    @SerializedName("League")
    String league;
    @SerializedName("Division")
    String division;
    @SerializedName("Wins")
    int wins;
    @SerializedName("Losses")
    int losses;
    @SerializedName("Percentage")
    float percentage;
    @SerializedName("GamesBehind")
    float gamesBehind;
    @SerializedName("LastTenGamesWins")
    int lastTenGamesWins;
    @SerializedName("LastTenGamesLosses")
    int lastTenGamesLosses;
    @SerializedName("Streak")
    String streak;
    @SerializedName("WildCardRank") // null값임
    int wildCardRank;
    @SerializedName("WildCardGamesBehind")
    float wildCardGamesBehind;
    @SerializedName("HomeWins")
    int homeWins;
    @SerializedName("HomeLosses")
    int homeLosses;
    @SerializedName("AwayWins")
    int awayWins;
    @SerializedName("AwayLosses")
    int awayLosses;
    @SerializedName("DayWins")
    int dayWins;
    @SerializedName("DayLosses")
    int dayLosses;
    @SerializedName("NightWins")
    int nightWins;
    @SerializedName("NightLosses")
    int nightLosses;
    @SerializedName("RunsScored")
    int runsScored;
    @SerializedName("RunsAgainst")
    int runsAgainst;

    public int getSeason() {
        return season;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getKey() {
        return key;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getDivision() {
        return division;
    }

    public String getLeague() {
        return league;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public float getPercentage() {
        return percentage;
    }

    public float getGamesBehind() {
        return gamesBehind;
    }

    public int getLastTenGamesWins() {
        return lastTenGamesWins;
    }

    public int getLastTenGamesLosses() {
        return lastTenGamesLosses;
    }

    public String getStreak() {
        return streak;
    }

    public int getWildCardRank() {
        return wildCardRank;
    }

    public float getWildCardGamesBehind() {
        return wildCardGamesBehind;
    }

    public int getHomeWins() {
        return homeWins;
    }

    public int getHomeLosses() {
        return homeLosses;
    }

    public int getAwayWins() {
        return awayWins;
    }

    public int getAwayLosses() {
        return awayLosses;
    }

    public int getDayWins() {
        return dayWins;
    }

    public int getDayLosses() {
        return dayLosses;
    }

    public int getNightWins() {
        return nightWins;
    }

    public int getNightLosses() {
        return nightLosses;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public int getRunsAgainst() {
        return runsAgainst;
    }
}
