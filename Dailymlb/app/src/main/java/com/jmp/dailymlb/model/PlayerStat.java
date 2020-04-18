package com.jmp.dailymlb.model;

import com.google.gson.annotations.SerializedName;

public class PlayerStat {
    @SerializedName("StatID")
    int statId;
    @SerializedName("TeamID")
    int teamId;
    @SerializedName("PlayerID")
    long playerId;
    @SerializedName("SeasonType")
    int seasonType;
    @SerializedName("Season")
    int season;
    @SerializedName("Name")
    String name;
    @SerializedName("Team")
    String team;
    @SerializedName("Position")
    String position;
    @SerializedName("PositionCategory")
    String positionCategory;
    @SerializedName("Games")
    int games;
    @SerializedName("Hits")
    float hits;
    @SerializedName("Runs")
    float runs;
    @SerializedName("HomeRuns")
    float homeRuns;
    @SerializedName("BattingAverage")
    float avg;
    @SerializedName("StolenBases")
    float stolenBases;
    @SerializedName("RunsBattedIn")
    float runsBattedIn;
    @SerializedName("Walks")
    float walks;
    @SerializedName("HitByPitch")
    float hitByPitch;
    @SerializedName("Strikeouts")
    float strikeouts;
    @SerializedName("Wins")
    float wins;
    @SerializedName("Losses")
    float losses;
    @SerializedName("Saves")
    float saves;
    @SerializedName("EarnedRunAverage")
    float era;
    @SerializedName("PitchingWalks")
    float pitchingWalk;
    @SerializedName("PitchingStrikeouts")
    float pitchingStrikeout;
    @SerializedName("PitchingHomeRuns")
    float pitchingHomeRuns;
    @SerializedName("WalksHitsPerInningsPitched")
    float whip;

    public int getStatId() {
        return statId;
    }

    public void setStatId(int statId) {
        this.statId = statId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionCategory() {
        return positionCategory;
    }

    public void setPositionCategory(String positionCategory) {
        this.positionCategory = positionCategory;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public float getHits() {
        return hits;
    }

    public void setHits(float hits) {
        this.hits = hits;
    }

    public float getRuns() {
        return runs;
    }

    public void setRuns(float runs) {
        this.runs = runs;
    }

    public float getHomeRuns() {
        return homeRuns;
    }

    public void setHomeRuns(float homeRuns) {
        this.homeRuns = homeRuns;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public float getStolenBases() {
        return stolenBases;
    }

    public void setStolenBases(float stolenBases) {
        this.stolenBases = stolenBases;
    }

    public float getRunsBattedIn() {
        return runsBattedIn;
    }

    public void setRunsBattedIn(float runsBattedIn) {
        this.runsBattedIn = runsBattedIn;
    }

    public float getWalks() {
        return walks;
    }

    public void setWalks(float walks) {
        this.walks = walks;
    }

    public float getHitByPitch() {
        return hitByPitch;
    }

    public void setHitByPitch(float hitByPitch) {
        this.hitByPitch = hitByPitch;
    }

    public float getStrikeouts() {
        return strikeouts;
    }

    public void setStrikeouts(float strikeouts) {
        this.strikeouts = strikeouts;
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

    public float getSaves() {
        return saves;
    }

    public void setSaves(float saves) {
        this.saves = saves;
    }

    public float getEra() {
        return era;
    }

    public void setEra(float era) {
        this.era = era;
    }

    public float getPitchingWalk() {
        return pitchingWalk;
    }

    public void setPitchingWalk(float pitchingWalk) {
        this.pitchingWalk = pitchingWalk;
    }

    public float getPitchingStrikeout() {
        return pitchingStrikeout;
    }

    public void setPitchingStrikeout(float pitchingStrikeout) {
        this.pitchingStrikeout = pitchingStrikeout;
    }

    public float getPitchingHomeRuns() {
        return pitchingHomeRuns;
    }

    public void setPitchingHomeRuns(float pitchingHomeRuns) {
        this.pitchingHomeRuns = pitchingHomeRuns;
    }

    public float getWhip() {
        return whip;
    }

    public void setWhip(float whip) {
        this.whip = whip;
    }
}
