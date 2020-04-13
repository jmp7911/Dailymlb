package com.jmp.dailymlb.model;

import java.util.Map;

public class Score {
    int gameId;
    String status;
    int homeId;
    int awayId;
    Map<Integer, Integer> awayTeamInnings;
    Map<Integer, Integer> homeTeamInnings;
    String homeTeam;
    String awayTeam;
    int awayTeamHits;
    int homeTeamHits;
    int awayTeamRuns;
    int homeTeamRuns;
    int awayTeamErrors;
    int homeTeamErrors;
    int winningPitcherId;
    int losingPitcherId;
    int savingPitcherId;

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public void setAwayId(int awayId) {
        this.awayId = awayId;
    }

    public void setAwayTeamInnings(Map<Integer, Integer> awayTeamInnings) {
        this.awayTeamInnings = awayTeamInnings;
    }

    public void setHomeTeamInnings(Map<Integer, Integer> homeTeamInnings) {
        this.homeTeamInnings = homeTeamInnings;
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

    public int getHomeId() {
        return homeId;
    }

    public int getAwayId() {
        return awayId;
    }

    public Map<Integer, Integer> getAwayTeamInnings() {
        return awayTeamInnings;
    }

    public Map<Integer, Integer> getHomeTeamInnings() {
        return homeTeamInnings;
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
