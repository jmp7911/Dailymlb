package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.GameScore;
import com.jmp.dailymlb.model.source.gameScore.GameScoreRepository;
import com.jmp.dailymlb.model.source.gameScore.GameScoreSource;

import java.text.SimpleDateFormat;
import java.util.List;

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
