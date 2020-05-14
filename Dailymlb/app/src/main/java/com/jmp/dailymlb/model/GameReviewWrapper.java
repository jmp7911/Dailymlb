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
    TableLayout tableStatistics;
    TextView awayTeamOnStatistics;
    TextView awayHitsOnStatistics;
    TextView awayHomeRuns;
    TextView awayStolenBases;
    TextView awayPitcherStrikeOut;
    TextView awayErrorsOnStatistics;
    TextView homeTeamOnStatistics;
    TextView homeHitsOnStatistics;
    TextView homeHomeRuns;
    TextView homeStolenBases;
    TextView homePitcherStrikeOut;
    TextView homeErrorsOnStatistics;

    public GameReviewWrapper(View root) {
        tableStatistics = root.findViewById(R.id.review_table_statistics);
        tableBoard = root.findViewById(R.id.review_table_board);
        awayStat = root.findViewById(R.id.away_team_stat);
        awayRank = root.findViewById(R.id.away_team_rank);
        awayIcon = root.findViewById(R.id.review_away_icon);
        awayScore = root.findViewById(R.id.review_text_away_score);
        reviewStatus = root.findViewById(R.id.review_text_status);
        homeScore = root.findViewById(R.id.review_text_home_score);
        homeIcon = root.findViewById(R.id.review_home_icon);
        homeRank = root.findViewById(R.id.home_team_rank);
        homeStat = root.findViewById(R.id.home_team_stat);
        awayTeamOnStatistics = root.findViewById(R.id.statistics_away_team);
        awayHitsOnStatistics = root.findViewById(R.id.statistics_away_hit);
        awayHomeRuns = root.findViewById(R.id.statistics_away_home_run);
        awayStolenBases = root.findViewById(R.id.statistics_away_stolen_base);
        awayPitcherStrikeOut = root.findViewById(R.id.statistics_away_pitcher_strike_out);
        awayErrorsOnStatistics = root.findViewById(R.id.statistics_away_error);
        homeTeamOnStatistics = root.findViewById(R.id.statistics_home_team);
        homeHitsOnStatistics = root.findViewById(R.id.statistics_home_hit);
        homeHomeRuns = root.findViewById(R.id.statistics_home_home_run);
        homeStolenBases = root.findViewById(R.id.statistics_home_stolen_base);
        homePitcherStrikeOut = root.findViewById(R.id.statistics_home_pitcher_strike_out);
        homeErrorsOnStatistics = root.findViewById(R.id.statistics_home_error);

    }

    public TableLayout getTableStatistics() {
        return tableStatistics;
    }

    public TableLayout getTableBoard() {
        return tableBoard;
    }

    public TextView getAwayHomeRuns() {
        return awayHomeRuns;
    }

    public TextView getAwayStolenBases() {
        return awayStolenBases;
    }

    public TextView getAwayPitcherStrikeOut() {
        return awayPitcherStrikeOut;
    }

    public TextView getAwayErrorsOnStatistics() {
        return awayErrorsOnStatistics;
    }

    public TextView getHomeTeamOnStatistics() {
        return homeTeamOnStatistics;
    }

    public TextView getHomeHitsOnStatistics() {
        return homeHitsOnStatistics;
    }

    public TextView getHomeHomeRuns() {
        return homeHomeRuns;
    }

    public TextView getHomeStolenBases() {
        return homeStolenBases;
    }

    public TextView getHomePitcherStrikeOut() {
        return homePitcherStrikeOut;
    }

    public TextView getHomeErrorsOnStatistics() {
        return homeErrorsOnStatistics;
    }

    public TextView getAwayTeamOnStatistics() {
        return awayTeamOnStatistics;
    }

    public TextView getAwayHitsOnStatistics() {
        return awayHitsOnStatistics;
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
