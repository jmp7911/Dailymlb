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
        String getGamesByDate(String key);
    }
}
