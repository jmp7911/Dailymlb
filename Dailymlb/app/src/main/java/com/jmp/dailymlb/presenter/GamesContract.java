package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.GameScore;
import com.jmp.dailymlb.model.source.gameScore.GameScoreRepository;

import java.util.List;

public interface GamesContract {
    interface View {
        void showToast(String title);
        void setGameScore(List<GameScore> games);
    }
    interface Presenter {
        void attachView(View view);
        void detachView();
        void setGameScoreData(GameScoreRepository gameScoreData);
        void loadGamesByDate();

    }
}
