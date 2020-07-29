package com.jmp.dailymlb.presenter;


import com.jmp.dailymlb.iface.OnClickResultListener;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mainView;

    @Override
    public void attachView(MainContract.View view) {
        this.mainView = view;
    }

    @Override
    public void detachView() {
        mainView = null;
    }

}
