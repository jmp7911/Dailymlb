package com.jmp.dailymlb.presenter;

public interface GamesContract {
    interface View {
        void showToast(String title);
    }
    interface Presenter {
        void attachView(View view);
        void detachView();
        void addItem();
        void setGamesAdapterModel(GamesAdapterContract.Model gamesAdapterModel);
        void setGamesAdapterView(GamesAdapterContract.View gamesAdapterView);
    }
}
