package com.jmp.dailymlb.model.source.gameScore.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jmp.dailymlb.model.GameScore;
import com.jmp.dailymlb.model.Retrofit2Client;
import com.jmp.dailymlb.model.source.gameScore.GameScoreSource;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.jmp.dailymlb.model.Constants.KEY;

public class GameScoreRemoteDataSource implements GameScoreSource {


    @Override
    public void getGames(final LoadGameCallback loadGameCallback) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        //Date date = new Date();
        //테스트용 날짜 2019-JUL-31
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DAY_OF_MONTH, 31);

        Call<List<GameScore>> gamesByDate = Retrofit2Client.getInstance().getApiService()
                .gamesByDate(sdf.format(calendar.getTime()), KEY);
        gamesByDate.enqueue(new Callback<List<GameScore>>() {
            @Override
            public void onResponse(Call<List<GameScore>> call, Response<List<GameScore>> response) {
                loadGameCallback.onLoadGameCallback(response.body());
            }

            @Override
            public void onFailure(Call<List<GameScore>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
