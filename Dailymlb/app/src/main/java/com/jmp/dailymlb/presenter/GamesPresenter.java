package com.jmp.dailymlb.presenter;

import android.util.Log;

import com.jmp.dailymlb.model.Game;
import com.jmp.dailymlb.model.Retrofit2Client;
import com.jmp.dailymlb.model.Stadium;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.facebook.stetho.inspector.network.ResponseHandlingInputStream.TAG;
import static com.jmp.dailymlb.model.Constants.API_KEY;
import static com.jmp.dailymlb.model.Constants.ONE_DAY_MILLS;

public class GamesPresenter implements GamesContract.Presenter {
    private GamesContract.View view ;

    @Override
    public void attachView(GamesContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void getGamesByDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        Date date = new Date(calendar.getTimeInMillis() - ONE_DAY_MILLS);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        Call<List<Game>> request = Retrofit2Client.getInstance().getApiService()
                .getGamesByDate(simpleDateFormat.format(date), API_KEY);
        request.enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                switch (response.code()) {
                    case 200 :
                        view.setGames(response.body());
                        break;
                    case 400 :
                        view.showToast("Error : Client error");
                        break;
                    case 404 :
                        view.showToast("Error : Not Found");
                        break;
                    case 500 :
                        view.showToast("Error : Internal Server error");
                        break;
                }
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                view.showToast(t.getMessage());
            }
        });
    }

    @Override
    public void getGamesByDate(Date today) {
        Date yesterday = new Date(today.getTime() - ONE_DAY_MILLS);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        Call<List<Game>> request = Retrofit2Client.getInstance().getApiService()
                .getGamesByDate(simpleDateFormat.format(yesterday), API_KEY);
        request.enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                switch (response.code()) {
                    case 200 :
                        view.setGames(response.body());
                        break;
                    case 400 :
                        view.showToast("Error : Client error");
                        break;
                    case 404 :
                        view.showToast("Error : Not Found");
                        break;
                    case 500 :
                        view.showToast("Error : Internal Server error");
                        break;
                }
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                view.showToast(t.getMessage());
            }
        });
    }

    @Override
    public void getStadiums() {
        Call<List<Stadium>> request = Retrofit2Client.getInstance().getApiService()
                .getStadiums(API_KEY);
        request.enqueue(new Callback<List<Stadium>>() {
            @Override
            public void onResponse(Call<List<Stadium>> call, Response<List<Stadium>> response) {
                switch (response.code()) {
                    case 200 :
                        view.setStadiums(response.body());
                        break;
                    case 400 :
                        view.showToast("Error : Client Error");
                    case 404 :
                        view.showToast("Error : Not Found");
                        break;
                    case 500 :
                        view.showToast("Error : Internal Server error");
                        break;
                }
            }

            @Override
            public void onFailure(Call<List<Stadium>> call, Throwable t) {
                view.showToast(t.getMessage());
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
