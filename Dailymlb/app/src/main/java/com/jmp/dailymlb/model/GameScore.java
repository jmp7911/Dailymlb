package com.jmp.dailymlb.model;

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
    @SerializedName("AwayTeamErrors")
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(int seasonType) {
        this.seasonType = seasonType;
    }

    public int getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(int stadiumId) {
        this.stadiumId = stadiumId;
    }

    public int getInning() {
        return inning;
    }

    public void setInning(int inning) {
        this.inning = inning;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
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

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public ArrayList<Inning> getInnings() {
        return innings;
    }

    public void setInnings(ArrayList<Inning> innings) {
        this.innings = innings;
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
