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
    TableLayout tableStat;
    TableLayout tableHit;
    TableLayout tableHomeRun;
    TableLayout tableStolenBase;
    TableLayout tablePitcherStrikeOut;
    TableLayout tableError;

    TextView awayHitOnStat;
    TextView homeHitOnStat;
    TextView awayHomeRunOnStat;
    TextView homeHomeRunOnStat;
    TextView awayStolenBaseOnStat;
    TextView homeStolenBaseOnStat;
    TextView awayPitcherStrikeOut;
    TextView homePitcherStrikeOut;
    TextView awayErrorOnStat;
    TextView homeErrorOnStat;
    TextView hitOnStat;
    TextView homeRunOnStat;
    TextView stolenBaseOnStat;
    TextView pitcherStrikeOutOnStat;
    TextView errorOnStat;
    public GameReviewWrapper(View root) {
        tableStat = root.findViewById(R.id.review_table_statistics);
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
        awayHitOnStat = root.findViewById(R.id.statistics_away_hit);
        homeHitOnStat = root.findViewById(R.id.statistics_home_hit);
        awayHomeRunOnStat = root.findViewById(R.id.statistics_away_home_run);
        homeHomeRunOnStat = root.findViewById(R.id.statistics_home_home_run);
        awayStolenBaseOnStat = root.findViewById(R.id.statistics_away_stolen_base);
        homeStolenBaseOnStat = root.findViewById(R.id.statistics_home_stolen_base);
        awayPitcherStrikeOut = root.findViewById(R.id.statistics_away_pitcher_strike_out);
        homePitcherStrikeOut = root.findViewById(R.id.statistics_home_pitcher_strike_out);
        awayErrorOnStat = root.findViewById(R.id.statistics_away_error);
        homeErrorOnStat = root.findViewById(R.id.statistics_home_error);
        hitOnStat = root.findViewById(R.id.statistics_hit);
        homeRunOnStat = root.findViewById(R.id.statistics_home_run);
        stolenBaseOnStat = root.findViewById(R.id.statistics_stolen_base);
        pitcherStrikeOutOnStat = root.findViewById(R.id.statistics_pitcher_strike_out);
        errorOnStat = root.findViewById(R.id.statistics_error);
    }

    public TableLayout getTableStat() {
        return tableStat;
    }

    public TableLayout getTableBoard() {
        return tableBoard;
    }

    public TextView getHitOnStat() {
        return hitOnStat;
    }

    public TextView getHomeRunOnStat() {
        return homeRunOnStat;
    }

    public TextView getStolenBaseOnStat() {
        return stolenBaseOnStat;
    }

    public TextView getPitcherStrikeOutOnStat() {
        return pitcherStrikeOutOnStat;
    }

    public TextView getErrorOnStat() {
        return errorOnStat;
    }

    public TextView getAwayHitOnStat() {
        return awayHitOnStat;
    }

    public TextView getHomeHitOnStat() {
        return homeHitOnStat;
    }

    public TextView getAwayHomeRunOnStat() {
        return awayHomeRunOnStat;
    }

    public TextView getHomeHomeRunOnStat() {
        return homeHomeRunOnStat;
    }

    public TextView getAwayStolenBaseOnStat() {
        return awayStolenBaseOnStat;
    }

    public TextView getHomeStolenBaseOnStat() {
        return homeStolenBaseOnStat;
    }

    public TextView getAwayPitcherStrikeOut() {
        return awayPitcherStrikeOut;
    }

    public TextView getHomePitcherStrikeOut() {
        return homePitcherStrikeOut;
    }

    public TextView getAwayErrorOnStat() {
        return awayErrorOnStat;
    }

    public TextView getHomeErrorOnStat() {
        return homeErrorOnStat;
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
