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

    public boolean isActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
