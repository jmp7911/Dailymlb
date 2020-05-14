package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.Game;
import com.jmp.dailymlb.model.Stadium;

import java.util.List;

public interface GamesContract {
    interface View {
        void showToast(String title);
        void setGames(List<Game> games);
        void setStadiums(List<Stadium> stadiums);
    }
    interface Presenter {
        void attachView(View view);
        void detachView();
        void getGamesByDate(int year, int month, int day);
        void getStadiums();
    }
}
