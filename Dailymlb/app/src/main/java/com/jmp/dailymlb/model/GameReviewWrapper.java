package com.jmp.dailymlb.model;

import android.view.View;
import android.widget.ImageView;
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

    TextView awayTeamOnBoard;
    TextView homeTeamOnBoard;
    TextView awayRunOn1stInning;
    TextView homeRunOn1stInning;
    TextView awayRunOn2ndInning;
    TextView homeRunOn2ndInning;
    TextView awayRunOn3rdInning;
    TextView homeRunOn3rdInning;
    TextView awayRunOn4thInning;
    TextView homeRunOn4thInning;
    TextView awayRunOn5thInning;
    TextView homeRunOn5thInning;
    TextView awayRunOn6thInning;
    TextView homeRunOn6thInning;
    TextView awayRunOn7thInning;
    TextView homeRunOn7thInning;
    TextView awayRunOn8thInning;
    TextView homeRunOn8thInning;
    TextView awayRunOn9thInning;
    TextView homeRunOn9thInning;
    TextView awayHitsOnBoard;
    TextView awayRunsOnBoard;
    TextView awayErrorsOnBoard;
    TextView awayBases;
    TextView homeHitsOnBoard;
    TextView homeRunsOnBoard;
    TextView homeErrorsOnBoard;
    TextView homeBases;
    public GameReviewWrapper(View root) {
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
        awayTeamOnBoard = root.findViewById(R.id.board_text_away_team);
        homeTeamOnBoard = root.findViewById(R.id.board_text_home_team);
        awayRunOn1stInning = root.findViewById(R.id.text_away_run_1st);
        homeRunOn1stInning = root.findViewById(R.id.text_home_run_1st);
        awayRunOn2ndInning = root.findViewById(R.id.text_away_run_2nd);
        homeRunOn2ndInning = root.findViewById(R.id.text_home_run_2nd);
        awayRunOn3rdInning = root.findViewById(R.id.text_away_run_3rd);
        homeRunOn3rdInning = root.findViewById(R.id.text_home_run_3rd);
        awayRunOn4thInning = root.findViewById(R.id.text_away_run_4th);
        homeRunOn4thInning = root.findViewById(R.id.text_home_run_4th);
        awayRunOn5thInning = root.findViewById(R.id.text_away_run_5th);
        homeRunOn5thInning = root.findViewById(R.id.text_home_run_5th);
        awayRunOn6thInning = root.findViewById(R.id.text_away_run_6th);
        homeRunOn6thInning = root.findViewById(R.id.text_home_run_6th);
        awayRunOn7thInning = root.findViewById(R.id.text_away_run_7th);
        homeRunOn7thInning = root.findViewById(R.id.text_home_run_7th);
        awayRunOn8thInning = root.findViewById(R.id.text_away_run_8th);
        homeRunOn8thInning = root.findViewById(R.id.text_home_run_8th);
        awayRunOn9thInning = root.findViewById(R.id.text_away_run_9th);
        homeRunOn9thInning = root.findViewById(R.id.text_home_run_9th);
        awayHitsOnBoard = root.findViewById(R.id.text_away_hit);
        awayRunsOnBoard = root.findViewById(R.id.text_away_run);
        awayErrorsOnBoard = root.findViewById(R.id.text_away_error);
        awayBases = root.findViewById(R.id.text_away_base);
        homeHitsOnBoard = root.findViewById(R.id.text_home_hit);
        homeRunsOnBoard = root.findViewById(R.id.text_home_run);
        homeErrorsOnBoard = root.findViewById(R.id.text_home_error);
        homeBases  = root.findViewById(R.id.text_home_base);
    }

    public TextView getAwayHitsOnBoard() {
        return awayHitsOnBoard;
    }

    public TextView getAwayRunsOnBoard() {
        return awayRunsOnBoard;
    }

    public TextView getAwayErrorsOnBoard() {
        return awayErrorsOnBoard;
    }

    public TextView getAwayBases() {
        return awayBases;
    }

    public TextView getHomeHitsOnBoard() {
        return homeHitsOnBoard;
    }

    public TextView getHomeRunsOnBoard() {
        return homeRunsOnBoard;
    }

    public TextView getHomeErrorsOnBoard() {
        return homeErrorsOnBoard;
    }

    public TextView getHomeBases() {
        return homeBases;
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

    public TextView getAwayTeamOnBoard() {
        return awayTeamOnBoard;
    }

    public TextView getHomeTeamOnBoard() {
        return homeTeamOnBoard;
    }

    public TextView getAwayRunOn1stInning() {
        return awayRunOn1stInning;
    }

    public TextView getHomeRunOn1stInning() {
        return homeRunOn1stInning;
    }

    public TextView getAwayRunOn2ndInning() {
        return awayRunOn2ndInning;
    }

    public TextView getHomeRunOn2ndInning() {
        return homeRunOn2ndInning;
    }

    public TextView getAwayRunOn3rdInning() {
        return awayRunOn3rdInning;
    }

    public TextView getHomeRunOn3rdInning() {
        return homeRunOn3rdInning;
    }

    public TextView getAwayRunOn4thInning() {
        return awayRunOn4thInning;
    }

    public TextView getHomeRunOn4thInning() {
        return homeRunOn4thInning;
    }

    public TextView getAwayRunOn5thInning() {
        return awayRunOn5thInning;
    }

    public TextView getHomeRunOn5thInning() {
        return homeRunOn5thInning;
    }

    public TextView getAwayRunOn6thInning() {
        return awayRunOn6thInning;
    }

    public TextView getHomeRunOn6thInning() {
        return homeRunOn6thInning;
    }

    public TextView getAwayRunOn7thInning() {
        return awayRunOn7thInning;
    }

    public TextView getHomeRunOn7thInning() {
        return homeRunOn7thInning;
    }

    public TextView getAwayRunOn8thInning() {
        return awayRunOn8thInning;
    }

    public TextView getHomeRunOn8thInning() {
        return homeRunOn8thInning;
    }

    public TextView getAwayRunOn9thInning() {
        return awayRunOn9thInning;
    }

    public TextView getHomeRunOn9thInning() {
        return homeRunOn9thInning;
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
