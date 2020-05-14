package com.jmp.dailymlb.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.model.Game;
import com.jmp.dailymlb.model.GameReviewWrapper;
import com.jmp.dailymlb.model.Inning;
import com.jmp.dailymlb.model.Play;
import com.jmp.dailymlb.model.PlayByPlay;
import com.jmp.dailymlb.model.Teams;
import com.jmp.dailymlb.presenter.GameReviewContract;
import com.jmp.dailymlb.presenter.GameReviewPresenter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class GameReviewFragment extends Fragment implements GameReviewContract.View {
    Context context;
    View view;
    int gameId;
    PlayByPlay playByPlay;
    GameReviewPresenter gameReviewPresenter;
    TableLayout tableStatistics;
    public GameReviewFragment(int gameId) {
        this.gameId = gameId;
        context = null;
        view = null;
        playByPlay = null;
        gameReviewPresenter = null;
        tableStatistics = null;
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
        for(Teams team : Teams.values()) {
            if (String.valueOf(team).equals(playByPlay.getGame().getAwayTeam())) {
                wrapper.getAwayIcon().setImageResource(team.getDrawableId());
            } else if (String.valueOf(team).equals(playByPlay.getGame().getHomeTeam())) {
                wrapper.getHomeIcon().setImageResource(team.getDrawableId());
            }
        }
        bindOnStatistics(wrapper);
        bindOnBoard(wrapper);
    }

    private void bindOnBoard(GameReviewWrapper wrapper) {
        Game game = playByPlay.getGame();
        ArrayList<Inning> innings = game.getInnings();
        TableRow row1 = new TableRow(context);
        TableRow row2 = new TableRow(context);
        TableRow row3 = new TableRow(context);
        wrapper.getTableBoard().addView(row1);
        wrapper.getTableBoard().addView(row2);
        wrapper.getTableBoard().addView(row3);
        TableRow.LayoutParams tableRowLayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);

        row1.setLayoutParams(tableRowLayoutParams);
        row2.setLayoutParams(tableRowLayoutParams);
        row3.setLayoutParams(tableRowLayoutParams);
        addBoardFirstColumn(row1, row2, row3);

        for(Inning inning : innings) {
            addBoardColumn(row1, String.valueOf(inning.getInningNumber()), row2, String.valueOf(inning.getAwayTeamRuns()),
                    row3, String.valueOf(inning.getHomeTeamRuns()));
        }
        addBoardColumn(row1, "R", row2, String.valueOf(game.getAwayTeamRuns()),
                row3, String.valueOf(game.getHomeTeamRuns()));
        addBoardColumn(row1, "H", row2, String.valueOf(game.getAwayTeamHits()),
                row3, String.valueOf(game.getHomeTeamHits()));
        addBoardColumn(row1, "E", row2, String.valueOf(game.getAwayTeamErrors()),
                row3, String.valueOf(game.getHomeTeamErrors()));
        addBoardColumn(row1, "B", row2, countBases(game.getAwayTeamId()),
                row3, countBases(game.getHomeTeamId()));
    }
    private void addBoardFirstColumn(TableRow row1, TableRow row2, TableRow row3) {
        TextView blankTextView = new TextView(context);
        TextView awayTeam = new TextView(context);
        TextView homeTeam = new TextView(context);
        row1.addView(blankTextView);
        row2.addView(awayTeam);
        row3.addView(homeTeam);
        float scale = context.getResources().getDisplayMetrics().density;
        int startDP = (int)scale;

        TableRow.LayoutParams layoutParams = (TableRow.LayoutParams)blankTextView.getLayoutParams();
        layoutParams.setMarginStart(startDP);
        blankTextView.setLayoutParams(layoutParams);
        layoutParams = (TableRow.LayoutParams)awayTeam.getLayoutParams();
        layoutParams.setMarginStart(startDP);
        awayTeam.setLayoutParams(layoutParams);
        layoutParams = (TableRow.LayoutParams)homeTeam.getLayoutParams();
        layoutParams.setMarginStart(startDP);
        homeTeam.setLayoutParams(layoutParams);

        awayTeam.setText(playByPlay.getGame().getAwayTeam());
        homeTeam.setText(playByPlay.getGame().getHomeTeam());

    }
    private void addBoardColumn(TableRow row1, String text1, TableRow row2, String text2, TableRow row3, String text3) {
        float scale = context.getResources().getDisplayMetrics().density;
        int startDP = (int)scale;

        TextView view1 = new TextView(context);
        row1.addView(view1);
        TableRow.LayoutParams layoutParams = (TableRow.LayoutParams)view1.getLayoutParams();
        layoutParams.setMarginStart(startDP);
        layoutParams.width = startDP * 20;
        view1.setLayoutParams(layoutParams);
        view1.setText(text1);
        view1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        view1.setBackgroundColor(ContextCompat.getColor(context, R.color.color1));
        TextView view2 = new TextView(context);
        row2.addView(view2);
        layoutParams = (TableRow.LayoutParams)view2.getLayoutParams();
        layoutParams.width = startDP * 20;
        layoutParams.setMarginStart(startDP);
        view2.setLayoutParams(layoutParams);
        view2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        view2.setText(text2);
        view2.setBackgroundColor(ContextCompat.getColor(context, R.color.color2));
        TextView view3 = new TextView(context);
        row3.addView(view3);
        layoutParams = (TableRow.LayoutParams)view3.getLayoutParams();
        layoutParams.width = startDP * 20;
        layoutParams.setMarginStart(startDP);
        view3.setLayoutParams(layoutParams);
        view3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        view3.setText(text3);
        view3.setBackgroundColor(ContextCompat.getColor(context, R.color.color3));

    }
    private String countBases(int teamId) {
        int count = 0;
        for(Play play : playByPlay.getPlays()) {
            if (play.getHitterTeamId() == teamId && play.isWalk()) {
                count++;
            }
        }
        return String.valueOf(count);
    }
    private void bindOnStatistics(GameReviewWrapper wrapper) {
        Game game = playByPlay.getGame();
        wrapper.getAwayTeamOnStatistics().setText(game.getAwayTeam());
        wrapper.getHomeTeamOnStatistics().setText(game.getHomeTeam());
        wrapper.getAwayHitsOnStatistics().setText(String.valueOf(game.getAwayTeamHits()));
        wrapper.getHomeHitsOnStatistics().setText(String.valueOf(game.getHomeTeamHits()));
        wrapper.getAwayHomeRuns().setText(countHomeRuns(game.getAwayTeamId()));
        wrapper.getHomeHomeRuns().setText(countHomeRuns(game.getHomeTeamId()));
        wrapper.getAwayPitcherStrikeOut().setText(countPitcherStrikeOut(game.getAwayTeamId()));
        wrapper.getHomePitcherStrikeOut().setText(countPitcherStrikeOut(game.getHomeTeamId()));
        wrapper.getAwayErrorsOnStatistics().setText(String.valueOf(game.getAwayTeamErrors()));
        wrapper.getHomeErrorsOnStatistics().setText(String.valueOf(game.getHomeTeamErrors()));
        wrapper.getAwayStolenBases().setText(countStolenBases(game.getAwayTeamId()));
        wrapper.getHomeStolenBases().setText(countStolenBases(game.getHomeTeamId()));
    }
    private void addRowDetail() {
        
    }
    private String countStolenBases(int teamId) {
        int count = 0;
        for(Play play : playByPlay.getPlays()) {
            if (play.getHitterTeamId() == teamId
                    && play.getResult().equals(getResources().getString(R.string.play_result_stolen_base))) {
                count++;
            }
        }
        return String.valueOf(count);
    }
    private String countHomeRuns(int teamId) {
        int count = 0;
        for(Play play : playByPlay.getPlays()) {
            if (play.getHitterTeamId() == teamId
                    && play.getResult().equals(getResources().getString(R.string.play_result_home_run))) {
                count++;
            }
        }
        return String.valueOf(count);
    }
    private String countPitcherStrikeOut(int teamId) {
        int count = 0;
        for(Play play : playByPlay.getPlays()) {
            if (play.getPitcherTeamId() == teamId && play.isStrikeout()) {
                count++;
            }
        }
        return String.valueOf(count);
    }
    @Override
    public void showToast(String title) {
        Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
    }

}
