package com.jmp.dailymlb.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.jmp.dailymlb.R;

public class GameReviewWrapper {

    TextView awayStat;
    TextView awayRank;
    ImageView awayIcon;
    TextView awayScore;
    TextView reviewStatus;
    TextView homeScore;
    ImageView homeIcon;
    TextView homeRank;
    TextView homeStat;

    TableLayout tableBoard;
    TableLayout tableHit;
    TableLayout tableHomeRun;
    TableLayout tableStolenBase;
    TableLayout tablePitcherStrikeOut;
    TableLayout tableError;

    public GameReviewWrapper(View root) {
        tableBoard = root.findViewById(R.id.review_table_board);
        tableHit = root.findViewById(R.id.review_table_hit);
        tableHomeRun = root.findViewById(R.id.review_table_home_run);
        tableStolenBase = root.findViewById(R.id.review_table_stolen_base);
        tablePitcherStrikeOut = root.findViewById(R.id.review_table_pitcher_strikeout);
        tableError = root.findViewById(R.id.review_table_error);
        awayStat = root.findViewById(R.id.away_team_stat);
        awayRank = root.findViewById(R.id.away_team_rank);
        awayIcon = root.findViewById(R.id.review_away_icon);
        awayScore = root.findViewById(R.id.review_text_away_score);
        reviewStatus = root.findViewById(R.id.review_text_status);
        homeScore = root.findViewById(R.id.review_text_home_score);
        homeIcon = root.findViewById(R.id.review_home_icon);
        homeRank = root.findViewById(R.id.home_team_rank);
        homeStat = root.findViewById(R.id.home_team_stat);
    }

    public TableLayout getTableBoard() {
        return tableBoard;
    }

    public TableLayout getTableHit() {
        return tableHit;
    }

    public TableLayout getTableHomeRun() {
        return tableHomeRun;
    }

    public TableLayout getTableStolenBase() {
        return tableStolenBase;
    }

    public TableLayout getTablePitcherStrikeOut() {
        return tablePitcherStrikeOut;
    }

    public TableLayout getTableError() {
        return tableError;
    }

    public TextView getAwayStat() {
        return awayStat;
    }

    public TextView getAwayRank() {
        return awayRank;
    }

    public ImageView getAwayIcon() {
        return awayIcon;
    }

    public TextView getAwayScore() {
        return awayScore;
    }

    public TextView getReviewStatus() {
        return reviewStatus;
    }

    public TextView getHomeScore() {
        return homeScore;
    }

    public ImageView getHomeIcon() {
        return homeIcon;
    }

    public TextView getHomeRank() {
        return homeRank;
    }

    public TextView getHomeStat() {
        return homeStat;
    }
}
