package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.GameScore;
import java.util.List;

public interface GamesContract {
    interface View {
        void showToast(String title);
        void setGameScore(List<GameScore> games);
    }
    interface Presenter {
        void attachView(View view);
        void detachView();
        void loadGamesByDate();

    }
}
