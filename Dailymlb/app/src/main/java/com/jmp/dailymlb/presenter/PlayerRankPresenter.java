package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.PlayerStat;
import com.jmp.dailymlb.model.Retrofit2Client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.jmp.dailymlb.model.Constants.API_KEY;

public class PlayerRankPresenter implements PlayerRankContract.Presenter {
    PlayerRankContract.View view;

    @Override
    public void getPlayerStats(Date today) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        int season = Integer.parseInt(simpleDateFormat.format(today));
        Call<List<PlayerStat>> request = Retrofit2Client.getInstance().getApiService()
                .getPlayerStats(2019, API_KEY);
        request.enqueue(new Callback<List<PlayerStat>>() {
            @Override
            public void onResponse(Call<List<PlayerStat>> call, Response<List<PlayerStat>> response) {
                if (response.code() == 200) {
                    view.setPlayerStats(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<PlayerStat>> call, Throwable t) {
                view.showToast(t.getMessage());
            }
        });
    }

    @Override
    public void attachView(PlayerRankContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
