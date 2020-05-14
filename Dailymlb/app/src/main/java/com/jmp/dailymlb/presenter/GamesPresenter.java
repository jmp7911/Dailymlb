package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.Game;
import com.jmp.dailymlb.model.Retrofit2Client;
import com.jmp.dailymlb.model.Stadium;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.jmp.dailymlb.model.Constants.KEY;

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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        Call<List<Game>> gamesByDate = Retrofit2Client.getInstance().getApiService()
                .getGamesByDate(simpleDateFormat.format(calendar.getTime()), KEY);
        gamesByDate.enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                if (response.code() == 200) {
                    view.setGames(response.body());
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
        Call<List<Stadium>> stadiums = Retrofit2Client.getInstance().getApiService()
                .getStadiums(KEY);
        stadiums.enqueue(new Callback<List<Stadium>>() {
            @Override
            public void onResponse(Call<List<Stadium>> call, Response<List<Stadium>> response) {
                if (response.code() == 200) {
                    view.setStadiums(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Stadium>> call, Throwable t) {
                view.showToast(t.getMessage());
            }
        });
    }
}
