package com.jmp.dailymlb.iface;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("/v3/mlb/scores/json/GamesByDate/{date}")
    Call<ResponseBody> gamesByDate(@Path("date") String date, @Query("key") String key);

}
