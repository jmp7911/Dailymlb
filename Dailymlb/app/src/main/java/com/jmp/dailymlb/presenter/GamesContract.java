package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.Game;
import java.util.List;

public interface GamesContract {
    interface View {
        void showToast(String title);
        void setGames(List<Game> games);
    }
    interface Presenter {
        void attachView(View view);
        void detachView();
        void getGamesByDate(int year, int month, int day);

    }
}
