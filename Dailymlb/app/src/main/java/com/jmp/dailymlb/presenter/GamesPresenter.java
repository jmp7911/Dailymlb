package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.Game;
import com.jmp.dailymlb.model.Retrofit2Client;

import java.util.List;

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
    public void loadGamesByDate(String date) {
        Call<List<Game>> gamesByDate = Retrofit2Client.getInstance().getApiService()
                .gamesByDate(date, KEY);
        gamesByDate.enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                view.setGames(response.body());
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
