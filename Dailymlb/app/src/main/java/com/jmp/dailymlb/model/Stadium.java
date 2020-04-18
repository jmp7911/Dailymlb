package com.jmp.dailymlb.model;

import com.google.gson.annotations.SerializedName;

public class Stadium {
    @SerializedName("StadiumID")
    int stadiumId;
    @SerializedName("Active")
    boolean isActive;
    @SerializedName("Name")
    String name;
    @SerializedName("City")
    String city;
    @SerializedName("State")
    String state;
    @SerializedName("Country")
    String country;

    public int getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(int stadiumId) {
        this.stadiumId = stadiumId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
