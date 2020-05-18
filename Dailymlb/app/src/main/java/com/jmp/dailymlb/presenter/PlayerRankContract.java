package com.jmp.dailymlb.presenter;


import com.jmp.dailymlb.model.PlayerStat;

import java.util.Date;
import java.util.List;

public interface PlayerRankContract {
    interface View {
        void showToast(String title);
        void setPlayerStats(List<PlayerStat> playerStats);
    }
    interface Presenter {
        void attachView(PlayerRankContract.View view);
        void detachView();
        void getPlayerStats(Date today);
    }
}
