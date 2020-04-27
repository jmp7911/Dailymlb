package com.jmp.dailymlb.iface;


import com.jmp.dailymlb.model.Game;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("/v3/mlb/scores/json/GamesByDate/{date}")
    Call<List<Game>> getGamesByDate(@Path("date") String date, @Query("key") String key);

}
