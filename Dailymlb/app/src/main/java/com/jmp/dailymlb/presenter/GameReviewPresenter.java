package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.iface.OnClickResultListener;
import com.jmp.dailymlb.model.Play;
import com.jmp.dailymlb.model.PlayByPlay;
import com.jmp.dailymlb.model.PlayerStat;
import com.jmp.dailymlb.model.Retrofit2Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.jmp.dailymlb.model.Constants.API_KEY;
import static com.jmp.dailymlb.model.Retrofit2Client.getInstance;

public class GameReviewPresenter implements GameReviewContract.Presenter {
    GameReviewContract.View view;

    @Override
    public void attachView(GameReviewContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getPlayByPlay(int gameId) {
        Call<PlayByPlay> request = Retrofit2Client.getInstance().getApiService().getPlayByPlay(gameId, API_KEY);
        request.enqueue(new Callback<PlayByPlay>() {
            @Override
            public void onResponse(Call<PlayByPlay> call, Response<PlayByPlay> response) {
                switch (response.code()) {
                    case 200 :
                        view.setPlayByPlay(response.body());
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
            public void onFailure(Call<PlayByPlay> call, Throwable t) {
                view.showToast(t.getMessage());
            }
        });
    }

    @Override
    public void getPlayerGameStat(String dateTime, int playerId) {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String date = simpleDateFormat1.format(simpleDateFormat2.parse(dateTime));
            Call<List<PlayerStat>> request = Retrofit2Client.getInstance().getApiService()
                    .getPlayerGameStat(date, playerId, API_KEY);
            request.enqueue(new Callback<List<PlayerStat>>() {
                @Override
                public void onResponse(Call<List<PlayerStat>> call, Response<List<PlayerStat>> response) {
                    switch (response.code()) {
                        case 200 :
                            if (response.body() != null) {
                                view.setPlayerGameStat(response.body().get(0));
                            } else {
                                view.showToast("empty data");
                            }
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
                public void onFailure(Call<List<PlayerStat>> call, Throwable t) {

                }
            });
        } catch (ParseException e) {
            view.showToast(e.getMessage());
        }

    }
}
