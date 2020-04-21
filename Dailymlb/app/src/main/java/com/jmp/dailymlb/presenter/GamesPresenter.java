package com.jmp.dailymlb.presenter;

public class GamesPresenter implements GamesContract.Presenter {
    private GamesContract.View view ;

    private GamesAdapterContract.Model gamesAdapterModel;
    private GamesAdapterContract.View gamesAdapterView;
    @Override
    public void addItem() {
        gamesAdapterModel.addItem();
        gamesAdapterView.notifyItem();
    }

    @Override
    public void attachView(GamesContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void setGamesAdapterModel(GamesAdapterContract.Model gamesAdapterModel) {
        this.gamesAdapterModel = gamesAdapterModel;
    }

    @Override
    public void setGamesAdapterView(GamesAdapterContract.View gamesAdapterView) {
        this.gamesAdapterView = gamesAdapterView;
    }
}
