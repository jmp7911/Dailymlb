package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.iface.OnClickResultListener;

public interface MainContract {
    public interface View {
        void showToast(String title);
    }
    public interface Presenter {
        void attachView(View view);
        void detachView();

    }
}
