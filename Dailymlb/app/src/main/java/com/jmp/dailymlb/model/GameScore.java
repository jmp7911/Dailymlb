package com.jmp.dailymlb.model;


import com.google.gson.annotations.SerializedName;
import com.jmp.dailymlb.model.Inning;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GameScore {
    @SerializedName("GameID")
    int gameId;
    @SerializedName("DateTime")
    String dateTime;
    @SerializedName("Status")
    String status;
    @SerializedName("Season")
    int season;
    @SerializedName("SeasonType")
    int seasonType;
    @SerializedName("StadiumID")
    int stadiumId;
    @SerializedName("HomeTeamID")
    int homeTeamId;
    @SerializedName("AwayTeamID")
    int awayTeamId;
    @SerializedName("Innings")
    ArrayList<Inning> innings;
    @SerializedName("Inning")
    int inning;
    @SerializedName("HomeTeam")
    String homeTeam;
    @SerializedName("AwayTeam")
    String awayTeam;
    @SerializedName("AwayTeamHits")
    int awayTeamHits;
    @SerializedName("HomeTeamHits")
    int homeTeamHits;
    @SerializedName("AwayTeamRuns")
    int awayTeamRuns;
    @SerializedName("HomeTeamRuns")
    int homeTeamRuns;
    @SerializedName("AwayTeamErros")
    int awayTeamErrors;
    @SerializedName("HomeTeamErrors")
    int homeTeamErrors;
    @SerializedName("WinningPitcherID")
    int winningPitcherId;
    @SerializedName("LosingPitcherID")
    int losingPitcherId;
    @SerializedName("SavingPitcherID")
    int savingPitcherId;

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setAwayTeamHits(int awayTeamHits) {
        this.awayTeamHits = awayTeamHits;
    }

    public void setHomeTeamHits(int homeTeamHits) {
        this.homeTeamHits = homeTeamHits;
    }

    public void setAwayTeamRuns(int awayTeamRuns) {
        this.awayTeamRuns = awayTeamRuns;
    }

    public void setHomeTeamRuns(int homeTeamRuns) {
        this.homeTeamRuns = homeTeamRuns;
    }

    public void setAwayTeamErrors(int awayTeamErrors) {
        this.awayTeamErrors = awayTeamErrors;
    }

    public void setHomeTeamErrors(int homeTeamErrors) {
        this.homeTeamErrors = homeTeamErrors;
    }

    public void setWinningPitcherId(int winningPitcherId) {
        this.winningPitcherId = winningPitcherId;
    }

    public void setLosingPitcherId(int losingPitcherId) {
        this.losingPitcherId = losingPitcherId;
    }

    public void setSavingPitcherId(int savingPitcherId) {
        this.savingPitcherId = savingPitcherId;
    }

    public int getGameId() {
        return gameId;
    }

    public String getStatus() {
        return status;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getAwayTeamHits() {
        return awayTeamHits;
    }

    public int getHomeTeamHits() {
        return homeTeamHits;
    }

    public int getAwayTeamRuns() {
        return awayTeamRuns;
    }

    public int getHomeTeamRuns() {
        return homeTeamRuns;
    }

    public int getAwayTeamErrors() {
        return awayTeamErrors;
    }

    public int getHomeTeamErrors() {
        return homeTeamErrors;
    }

    public int getWinningPitcherId() {
        return winningPitcherId;
    }

    public int getLosingPitcherId() {
        return losingPitcherId;
    }

    public int getSavingPitcherId() {
        return savingPitcherId;
    }
}
