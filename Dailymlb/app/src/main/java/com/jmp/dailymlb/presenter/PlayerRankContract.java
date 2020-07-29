package com.jmp.dailymlb.presenter;


import com.jmp.dailymlb.model.PlayerStat;
import com.jmp.dailymlb.model.Team;
import com.jmp.dailymlb.model.TeamStat;

import java.util.Date;
import java.util.List;

public interface PlayerRankContract {
    interface View {
        void showToast(String title);
        void setPlayerStats(List<PlayerStat> playerStats);
        void setTeamStats(List<TeamStat> teamStats);
        void setTeams(List<Team> teams);
    }
    interface Presenter {
        void attachView(PlayerRankContract.View view);
        void detachView();
        void getPlayerStats(Date today);
        void getTeamStats(Date today);
        void getTeams();
    }
}
