package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.iface.OnClickResultListener;
import com.jmp.dailymlb.model.Play;
import com.jmp.dailymlb.model.PlayByPlay;
import com.jmp.dailymlb.model.Retrofit2Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.jmp.dailymlb.model.Constants.KEY;
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
        Call<PlayByPlay> getPlayByPlay = Retrofit2Client.getInstance().getApiService().getPlayByPlay(gameId, KEY);
        getPlayByPlay.enqueue(new Callback<PlayByPlay>() {
            @Override
            public void onResponse(Call<PlayByPlay> call, Response<PlayByPlay> response) {
                if (response.code() == 200) {
                    view.setPlayByPlay(response.body());
                }
            }

            @Override
            public void onFailure(Call<PlayByPlay> call, Throwable t) {
                view.showToast(t.getMessage());
            }
        });
    }
}
