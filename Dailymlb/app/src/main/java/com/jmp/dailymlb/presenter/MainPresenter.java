package com.jmp.dailymlb.presenter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jmp.dailymlb.R;
import com.jmp.dailymlb.iface.APIService;
import com.jmp.dailymlb.model.GameScore;
import com.jmp.dailymlb.model.PlayByPlay;
import com.jmp.dailymlb.model.PlayerStat;
import com.jmp.dailymlb.model.Stadium;
import com.jmp.dailymlb.model.Team;
import com.jmp.dailymlb.model.TeamStat;
import com.jmp.dailymlb.view.GamesByDateFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private Retrofit retrofit;
    private APIService apiService;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void addFragment(FragmentManager fragmentManager) {
        GamesByDateFragment dateFragment = new GamesByDateFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_layout, dateFragment).commit();
    }

    @Override
    public void connectAPIService(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);
    }

    @Override
    public void requestGamesByDate(String key) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        //Date date = new Date();
        //테스트용 날짜 2019-JUL-31
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DAY_OF_MONTH, 31);

        Call<List<GameScore>> gamesByDate = apiService.getGamesByDate(sdf.format(calendar.getTime()), key);
        gamesByDate.enqueue(new Callback<List<GameScore>>() {
            @Override
            public void onResponse(Call<List<GameScore>> call, Response<List<GameScore>> response) {
                Gson gson = new GsonBuilder().create();
                System.out.println(gson.toJson(response.body().get(0)));
            }

            @Override
            public void onFailure(Call<List<GameScore>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void requestPlaysByPlay(int gameId, String key) {
        //테스트용 gameId 55772
        int testGameId = 55772;
        Call<PlayByPlay> playsByPlay = apiService.getPlaysByPlay(testGameId, key);
        playsByPlay.enqueue(new Callback<PlayByPlay>() {
            @Override
            public void onResponse(Call<PlayByPlay> call, Response<PlayByPlay> response) {
                Gson gson = new GsonBuilder().create();
                PlayByPlay pbp = response.body();
                System.out.println(gson.toJson(pbp.getPlays().get(pbp.getPlays().size() - 1)));
            }

            @Override
            public void onFailure(Call<PlayByPlay> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void requestStadiums(String key) {
        Call<List<Stadium>> stadium = apiService.getStadiums(key);
        stadium.enqueue(new Callback<List<Stadium>>() {
            @Override
            public void onResponse(Call<List<Stadium>> call, Response<List<Stadium>> response) {
                Gson gson = new GsonBuilder().create();
                System.out.println(gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<List<Stadium>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void requestTeams(String key) {
        Call<List<Team>> team = apiService.getTeams(key);
        team.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                Gson gson = new GsonBuilder().create();
                System.out.println(gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {

            }
        });
    }

    @Override
    public void requestTeamStats(int season, String key) {
        //테스트용 season 2019
        int testSeason = 2019;
        Call<List<TeamStat>> teamStats = apiService.getTeamStats(season, key);
        teamStats.enqueue(new Callback<List<TeamStat>>() {
            @Override
            public void onResponse(Call<List<TeamStat>> call, Response<List<TeamStat>> response) {
                Gson gson = new GsonBuilder().create();
                System.out.println(gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<List<TeamStat>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void requestPlayerStats(int season, String key) {
        //테스트용 season 2019
        int testSeason = 2019;
        Call<List<PlayerStat>> playerStats = apiService.getPlayerStats(testSeason, key);
        playerStats.enqueue(new Callback<List<PlayerStat>>() {
            @Override
            public void onResponse(Call<List<PlayerStat>> call, Response<List<PlayerStat>> response) {
                Gson gson = new GsonBuilder().create();
                System.out.println(gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<List<PlayerStat>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
