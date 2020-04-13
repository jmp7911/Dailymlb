package com.jmp.dailymlb.iface;

import com.jmp.dailymlb.model.Score;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("/scores/json/GamesByDate/{date}")
    Call<Score> gamesByDate(@Path("date") String date, @Query("key") String key);

}
