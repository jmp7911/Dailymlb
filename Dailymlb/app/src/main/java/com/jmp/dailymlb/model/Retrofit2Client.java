package com.jmp.dailymlb.model;

import com.jmp.dailymlb.iface.APIService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.jmp.dailymlb.model.Constants.BASE_URL;

public class Retrofit2Client {
    private static Retrofit2Client instance = null;
    private Retrofit retrofit;
    private APIService apiService;


    private Retrofit2Client() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);
    }

    public static Retrofit2Client getInstance() {
        if (instance == null) {
            instance = new Retrofit2Client();
        }
        return instance;
    }

    public APIService getApiService() {
        return apiService;
    }
