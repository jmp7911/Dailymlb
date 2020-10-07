package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.PlayerStat;
import com.jmp.dailymlb.model.Retrofit2Client;
import com.jmp.dailymlb.model.Team;
import com.jmp.dailymlb.model.TeamStat;

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
                .getPlayerStats(season, API_KEY);
        request.enqueue(new Callback<List<PlayerStat>>() {
            @Override
            public void onResponse(Call<List<PlayerStat>> call, Response<List<PlayerStat>> response) {
                switch (response.code()) {
                    case 200:
                        view.setPlayerStats(response.body());
                        break;
                    case 400:
                        view.showToast("Error : Client Error");
                        break;
                    case 404:
                        view.showToast("Error : Not Found");
                        break;
                    case 500:
                        view.showToast("Error : Internal Server Error");
                }
                view.dismiss();
            }

            @Override
            public void onFailure(Call<List<PlayerStat>> call, Throwable t) {
                view.showToast(t.getMessage());
                view.dismiss();
            }
        });
    }

    @Override
    public void getTeamStats(Date today) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        int season = Integer.parseInt(simpleDateFormat.format(today));
        Call<List<TeamStat>> request = Retrofit2Client.getInstance().getApiService()
                .getTeamStats(season, API_KEY);
        request.enqueue(new Callback<List<TeamStat>>() {
            @Override
            public void onResponse(Call<List<TeamStat>> call, Response<List<TeamStat>> response) {
                switch (response.code()) {
                    case 200:
                        view.setTeamStats(response.body());
                        break;
                    case 400:
                        view.showToast("Error : Client Error");
                        break;
                    case 404:
                        view.showToast("Error : Not Found");
                        break;
                    case 500:
                        view.showToast("Error : Internal Server Error");
                }
            }

            @Override
            public void onFailure(Call<List<TeamStat>> call, Throwable t) {
                view.showToast(t.getMessage());
            }
        });
    }

    @Override
    public void getTeams() {
        Call<List<Team>> request = Retrofit2Client.getInstance().getApiService()
                .getTeams(API_KEY);
        request.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                switch (response.code()) {
                    case 200:
                        view.setTeams(response.body());
                        break;
                    case 400:
                        view.showToast("Error : Client Error");
                        break;
                    case 404:
                        view.showToast("Error : Not Found");
                        break;
                    case 500:
                        view.showToast("Error : Internal Server Error");
                }
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
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
