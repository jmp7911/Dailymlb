package com.jmp.dailymlb.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("TeamID")
    int teamId;
    @SerializedName("Team")
    String team;
    @SerializedName("Active")
    boolean isActive;
    @SerializedName("City")
    String city;
    @SerializedName("Name")
    String name;
    @SerializedName("StadiumID")
    int stadiumId;
    @SerializedName("League")
    String league;
    @SerializedName("Division")
    String division;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(int stadiumId) {
        this.stadiumId = stadiumId;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
