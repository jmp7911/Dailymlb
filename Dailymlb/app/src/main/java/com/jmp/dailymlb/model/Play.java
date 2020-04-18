package com.jmp.dailymlb.model;

import com.google.gson.annotations.SerializedName;

public class Play {
    int gameId;
    int season;
    long playId;
    int inningNumber;
    String result;
    boolean strikeOut;
    boolean walk;
    boolean hit;
    int pitcherTeamId;
    int hitterTeamId;
    int pitcherId;
    int hitterId;
    String pitcherName;
    String hitterName;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public long getPlayId() {
        return playId;
    }

    public void setPlayId(long playId) {
        this.playId = playId;
    }

    public int getInningNumber() {
        return inningNumber;
    }

    public void setInningNumber(int inningNumber) {
        this.inningNumber = inningNumber;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isStrikeOut() {
        return strikeOut;
    }

    public void setStrikeOut(boolean strikeOut) {
        this.strikeOut = strikeOut;
    }

    public boolean isWalk() {
        return walk;
    }

    public void setWalk(boolean walk) {
        this.walk = walk;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public int getPitcherTeamId() {
        return pitcherTeamId;
    }

    public void setPitcherTeamId(int pitcherTeamId) {
        this.pitcherTeamId = pitcherTeamId;
    }

    public int getHitterTeamId() {
        return hitterTeamId;
    }

    public void setHitterTeamId(int hitterTeamId) {
        this.hitterTeamId = hitterTeamId;
    }

    public int getPitcherId() {
        return pitcherId;
    }

    public void setPitcherId(int pitcherId) {
        this.pitcherId = pitcherId;
    }

    public int getHitterId() {
        return hitterId;
    }

    public void setHitterId(int hitterId) {
        this.hitterId = hitterId;
    }

    public String getPitcherName() {
        return pitcherName;
    }

    public void setPitcherName(String pitcherName) {
        this.pitcherName = pitcherName;
    }

    public String getHitterName() {
        return hitterName;
    }

    public void setHitterName(String hitterName) {
        this.hitterName = hitterName;
    }
}
