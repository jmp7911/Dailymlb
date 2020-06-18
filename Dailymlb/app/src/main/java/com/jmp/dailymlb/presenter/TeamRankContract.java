package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.Team;
import com.jmp.dailymlb.model.TeamStat;

import java.util.List;

public interface TeamRankContract {
    interface View {
        void showToast(String title);
        void setTeamStats(List<TeamStat> teamStats);
        void setTeams(List<Team> teams);
    }
    interface Presenter {
        void attachView(TeamRankContract.View view);
        void detachView();
        void getTeamStats(int season);
        void getTeams();
    }
}
