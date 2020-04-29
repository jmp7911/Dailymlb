package com.jmp.dailymlb.presenter;

public interface MainContract {
    public interface View {
        void showToast(String title);

    }
    public interface Presenter {
        void attachView(View view);
        void detachView();


    }
}
