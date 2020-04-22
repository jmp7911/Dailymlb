package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.source.gameScore.GameScoreRepository;

public interface GamesContract {
    interface View {
        void showToast(String title);
    }
    interface Presenter {
        void attachView(View view);
        void detachView();
        void setGamesAdapterModel(GamesAdapterContract.Model gamesAdapterModel);
        void setGamesAdapterView(GamesAdapterContract.View gamesAdapterView);
        void setGameScoreData(GameScoreRepository gameScoreData);
        void loadGamesByDate();

    }
}
