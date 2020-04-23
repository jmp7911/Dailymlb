package com.jmp.dailymlb.model.source.gameScore;

import com.jmp.dailymlb.model.GameScore;
import com.jmp.dailymlb.model.source.gameScore.remote.GameScoreRemoteDataSource;

import java.util.List;

public class GameScoreRepository implements GameScoreSource {
    private static GameScoreRepository gameScoreRepository = null;
    private GameScoreRemoteDataSource gameScoreRemoteDataSource;

    private GameScoreRepository() {
        gameScoreRemoteDataSource = GameScoreRemoteDataSource.getInstance();
    }

    public static GameScoreRepository getInstance() {
        if (gameScoreRepository == null) {
            gameScoreRepository = new GameScoreRepository();
        }
        return gameScoreRepository;
    }

    @Override
    public void getGames(final LoadGameCallback loadGameCallback) {
        gameScoreRemoteDataSource.getGames(new LoadGameCallback() {
            @Override
            public void onLoadGameCallback(List<GameScore> games) {
                if (loadGameCallback != null) {
                    loadGameCallback.onLoadGameCallback(games);
                }
            }
        });
    }
}
