package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.GameScore;

import java.util.List;

public interface GamesAdapterContract {
    interface View {
        void notifyItem();
    }
    interface Model {
        void addItem(List<GameScore> games);
    }
}
