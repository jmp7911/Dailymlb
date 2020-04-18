package com.jmp.dailymlb.presenter;

import android.view.View;

import androidx.fragment.app.FragmentManager;

public interface MainContract {
    public interface View {
        void showToast(String title);
    }
    public interface Presenter {
        void attachView(View view);
        void detachView();
        void addFragment(FragmentManager fragmentManager);
        void connectAPIService(String baseUrl);
        void requestGamesByDate(String key);
        void requestPlaysByPlay(int gameId, String key);
        void requestStadiums(String key);
        void requestTeams(String key);
        void requestTeamStats(int season, String key);
        void requestPlayerStats(int season, String key);
    }
}
