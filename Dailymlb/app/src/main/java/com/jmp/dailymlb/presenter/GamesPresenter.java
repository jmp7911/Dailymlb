package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.GameScore;
import com.jmp.dailymlb.model.source.gameScore.GameScoreRepository;
import com.jmp.dailymlb.model.source.gameScore.GameScoreSource;

import java.util.List;

public class GamesPresenter implements GamesContract.Presenter {
    private GamesContract.View view ;

    private GameScoreRepository gameScoreData;

    @Override
    public void attachView(GamesContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }


    @Override
    public void setGameScoreData(GameScoreRepository gameScoreData) {
        this.gameScoreData = gameScoreData;
    }

    @Override
    public void loadGamesByDate() {
        gameScoreData.getGames(new GameScoreSource.LoadGameCallback() {
            @Override
            public void onLoadGameCallback(List<GameScore> games) {
                view.setGameScore(games);
            }
        });
    }
}
