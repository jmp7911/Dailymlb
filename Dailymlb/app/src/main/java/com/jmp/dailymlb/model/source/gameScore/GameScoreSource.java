package com.jmp.dailymlb.model.source.gameScore;

import com.jmp.dailymlb.model.GameScore;

import java.util.List;

public interface GameScoreSource {
    interface LoadGameCallback {
        void onLoadGameCallback(List<GameScore> games);
    }
    void getGames(LoadGameCallback loadGameCallback);

}
