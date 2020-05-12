package com.jmp.dailymlb.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.model.Constants;
import com.jmp.dailymlb.model.GameReviewWrapper;
import com.jmp.dailymlb.model.Inning;
import com.jmp.dailymlb.model.PlayByPlay;
import com.jmp.dailymlb.presenter.GameReviewContract;
import com.jmp.dailymlb.presenter.GameReviewPresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GameReviewFragment extends Fragment implements GameReviewContract.View {
    Context context;
    View view;
    int gameId;
    PlayByPlay playByPlay;
    GameReviewPresenter gameReviewPresenter;

    public GameReviewFragment(int gameId) {
        this.gameId = gameId;
        context = null;
        view = null;
        playByPlay = null;
        gameReviewPresenter = null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_game_review, container, false);
        GameReviewWrapper wrapper = new GameReviewWrapper(view);
        view.setTag(wrapper);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gameReviewPresenter = new GameReviewPresenter();
        gameReviewPresenter.attachView(this);
        gameReviewPresenter.getPlayByPlay(gameId);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        gameReviewPresenter.detachView();
    }

    @Override
    public void setPlayByPlay(PlayByPlay playByPlay) {
        this.playByPlay = playByPlay;
        GameReviewWrapper wrapper = (GameReviewWrapper)view.getTag();

        wrapper.getAwayScore().setText(String.valueOf(playByPlay.getGame().getAwayTeamRuns()));
        wrapper.getReviewStatus().setText(playByPlay.getGame().getStatus());
        wrapper.getHomeScore().setText(String.valueOf(playByPlay.getGame().getHomeTeamRuns()));
        for(Constants.Team team : Constants.Team.values()) {
            if (String.valueOf(team).equals(playByPlay.getGame().getAwayTeam())) {
                wrapper.getAwayIcon().setImageResource(team.getDrawableId());
            } else if (String.valueOf(team).equals(playByPlay.getGame().getHomeTeam())) {
                wrapper.getHomeIcon().setImageResource(team.getDrawableId());
            }
        }
        setStatistics(wrapper);
        setBoard(wrapper);
    }
    private void setBoard(GameReviewWrapper wrapper) {
        wrapper.getAwayTeamOnBoard().setText(playByPlay.getGame().getAwayTeam());
        wrapper.getHomeTeamOnBoard().setText(playByPlay.getGame().getHomeTeam());
        ArrayList<Inning> innings = playByPlay.getGame().getInnings();
        for(Inning inning : innings) {
            if (inning.getInningNumber() == 1) {
                wrapper.getAwayRunOn1stInning().setText(String.valueOf(inning.getAwayTeamRuns()));
                wrapper.getHomeRunOn1stInning().setText(String.valueOf(inning.getHomeTeamRuns()));
            } else if (inning.getInningNumber() == 2) {
                wrapper.getAwayRunOn2ndInning().setText(String.valueOf(inning.getAwayTeamRuns()));
                wrapper.getHomeRunOn2ndInning().setText(String.valueOf(inning.getHomeTeamRuns()));
            } else if (inning.getInningNumber() == 3) {
                wrapper.getAwayRunOn3rdInning().setText(String.valueOf(inning.getAwayTeamRuns()));
                wrapper.getHomeRunOn3rdInning().setText(String.valueOf(inning.getHomeTeamRuns()));
            } else if (inning.getInningNumber() == 4) {
                wrapper.getAwayRunOn4thInning().setText(String.valueOf(inning.getAwayTeamRuns()));
                wrapper.getHomeRunOn4thInning().setText(String.valueOf(inning.getHomeTeamRuns()));
            } else if (inning.getInningNumber() == 5) {
                wrapper.getAwayRunOn5thInning().setText(String.valueOf(inning.getAwayTeamRuns()));
                wrapper.getHomeRunOn5thInning().setText(String.valueOf(inning.getHomeTeamRuns()));
            } else if (inning.getInningNumber() == 6) {
                wrapper.getAwayRunOn6thInning().setText(String.valueOf(inning.getAwayTeamRuns()));
                wrapper.getHomeRunOn6thInning().setText(String.valueOf(inning.getHomeTeamRuns()));
            } else if (inning.getInningNumber() == 7) {
                wrapper.getAwayRunOn7thInning().setText(String.valueOf(inning.getAwayTeamRuns()));
                wrapper.getHomeRunOn7thInning().setText(String.valueOf(inning.getHomeTeamRuns()));
            } else if (inning.getInningNumber() == 8) {
                wrapper.getAwayRunOn8thInning().setText(String.valueOf(inning.getAwayTeamRuns()));
                wrapper.getHomeRunOn8thInning().setText(String.valueOf(inning.getHomeTeamRuns()));
            } else if (inning.getInningNumber() == 9) {
                wrapper.getAwayRunOn9thInning().setText(String.valueOf(inning.getAwayTeamRuns()));
                wrapper.getHomeRunOn9thInning().setText(String.valueOf(inning.getHomeTeamRuns()));
            }
        }
        wrapper.getAwayHitsOnBoard().setText(String.valueOf(playByPlay.getGame().getAwayTeamHits()));
        wrapper.getHomeHitsOnBoard().setText(String.valueOf(playByPlay.getGame().getHomeTeamHits()));
        wrapper.getAwayRunsOnBoard().setText(String.valueOf(playByPlay.getGame().getAwayTeamRuns()));
        wrapper.getHomeRunsOnBoard().setText(String.valueOf(playByPlay.getGame().getHomeTeamRuns()));
        wrapper.getAwayErrorsOnBoard().setText(String.valueOf(playByPlay.getGame().getAwayTeamErrors()));
        wrapper.getHomeErrorsOnBoard().setText(String.valueOf(playByPlay.getGame().getHomeTeamErrors()));
        wrapper.getAwayBases().setText(String.valueOf(0));
        wrapper.getHomeBases().setText(String.valueOf(0));
    }
    private void setStatistics(GameReviewWrapper wrapper) {
        wrapper.getAwayHitsOnStatistics().setText(String.valueOf(playByPlay.getGame().getAwayTeamHits()));
        wrapper.getAwayTeamOnStatistics().setText(playByPlay.getGame().getAwayTeam());
        wrapper.getAwayHomeRuns().setText(String.valueOf(0));
        wrapper.getAwayPitcherStrikeOut().setText(String.valueOf(0));
        wrapper.getAwayErrorsOnStatistics().setText(String.valueOf(playByPlay.getGame().getAwayTeamErrors()));
        wrapper.getHomeTeamOnStatistics().setText(playByPlay.getGame().getHomeTeam());
        wrapper.getHomeHitsOnStatistics().setText(String.valueOf(playByPlay.getGame().getHomeTeamHits()));
        wrapper.getHomeHomeRuns().setText(String.valueOf(0));
        wrapper.getHomePitcherStrikeOut().setText(String.valueOf(0));
        wrapper.getHomeErrorsOnStatistics().setText(String.valueOf(playByPlay.getGame().getHomeTeamErrors()));
    }
    @Override
    public void showToast(String title) {
        Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
    }

}
