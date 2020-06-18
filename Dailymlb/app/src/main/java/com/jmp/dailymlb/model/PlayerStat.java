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
    @SerializedName("AtBats")
    float atBats;
    @SerializedName("Hits")
    float hits;
    @SerializedName("Runs")
    float runs;
    @SerializedName("HomeRuns")
    float homeRuns;
    @SerializedName("BattingAverage")
    float avg;
    @SerializedName("OnBasePlusSlugging")
    float ops;
    @SerializedName("OnBasePercentage")
    float obp;
    @SerializedName("SluggingPercentage")
    float slg;
    @SerializedName("StolenBases")
    float stolenBases;
    @SerializedName("RunsBattedIn")
    float runsBattedIn;
    @SerializedName("Walks")
    float walks;
    @SerializedName("HitByPitch")
    float hitByPitch;
    @SerializedName("InningsPitchedDecimal")
    float inningsPitched;
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

    public float getInningsPitched() {
        return inningsPitched;
    }

    public float getAtBats() {
        return atBats;
    }

    public int getStatId() {
        return statId;
    }

    public int getTeamId() {
        return teamId;
    }

    public long getPlayerId() {
        return playerId;
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

    public String getPosition() {
        return position;
    }

    public String getPositionCategory() {
        return positionCategory;
    }

    public int getGames() {
        return games;
    }

    public float getHits() {
        return hits;
    }

    public float getRuns() {
        return runs;
    }

    public float getHomeRuns() {
        return homeRuns;
    }

    public float getAvg() {
        return avg;
    }

    public float getOps() {
        return ops;
    }

    public float getObp() {
        return obp;
    }

    public float getSlg() {
        return slg;
    }

    public float getStolenBases() {
        return stolenBases;
    }

    public float getRunsBattedIn() {
        return runsBattedIn;
    }

    public float getWalks() {
        return walks;
    }

    public float getHitByPitch() {
        return hitByPitch;
    }

    public float getStrikeouts() {
        return strikeouts;
    }

    public float getWins() {
        return wins;
    }

    public float getLosses() {
        return losses;
    }

    public float getSaves() {
        return saves;
    }

    public float getEra() {
        return era;
    }

    public float getPitchingWalk() {
        return pitchingWalk;
    }

    public float getPitchingStrikeout() {
        return pitchingStrikeout;
    }

    public float getPitchingHomeRuns() {
        return pitchingHomeRuns;
    }

    public float getWhip() {
        return whip;
    }
}
