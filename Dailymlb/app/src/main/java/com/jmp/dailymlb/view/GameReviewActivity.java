package com.jmp.dailymlb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.model.Game;
import com.jmp.dailymlb.model.GameStatus;
import com.jmp.dailymlb.model.Inning;
import com.jmp.dailymlb.model.Play;
import com.jmp.dailymlb.model.PlayByPlay;
import com.jmp.dailymlb.model.PlayerStat;
import com.jmp.dailymlb.model.Teams;
import com.jmp.dailymlb.presenter.GameReviewContract;
import com.jmp.dailymlb.presenter.GameReviewPresenter;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import static com.jmp.dailymlb.model.Constants.GAME_ID;

public class GameReviewActivity extends AppCompatActivity implements GameReviewContract.View {
    PlayByPlay playByPlay;
    PlayerStat playerGameStat;
    int gameId;
    GameReviewPresenter gameReviewPresenter;
    GridView inningBoard;
    GridView stat;
    GameReviewInningAdapter gameReviewAdapter;
    GameReviewStatisticsAdapter gameReviewStatisticsAdapter;
    ImageView awayIcon;
    TextView awayScore;
    TextView homeScore;
    ImageView homeIcon;
    TextView textGameStatus;
    TextView winningPitcherText;
    TextView winningPitcherLabel;
    TextView savingPitcherText;
    TextView savingPitcherLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_review);
        inningBoard = findViewById(R.id.review_inning_board_grid_view);
        stat = findViewById(R.id.review_statistics_grid_view);
        awayIcon = findViewById(R.id.review_away_icon);
        awayScore = findViewById(R.id.review_text_away_score);
        homeIcon = findViewById(R.id.review_home_icon);
        homeScore = findViewById(R.id.review_text_home_score);
        textGameStatus = findViewById(R.id.review_text_status);
        winningPitcherText = findViewById(R.id.text_winning_pitcher);
        winningPitcherLabel = findViewById(R.id.text_winning_pitcher_label);
        savingPitcherText = findViewById(R.id.text_saving_pitcher);
        savingPitcherLabel = findViewById(R.id.text_saving_pitcher_label);
        Intent intent = getIntent();
        gameId = intent.getIntExtra(GAME_ID, 0);
        gameReviewPresenter = new GameReviewPresenter();
        gameReviewPresenter.attachView(this);

        gameReviewAdapter = new GameReviewInningAdapter(this);
        gameReviewStatisticsAdapter = new GameReviewStatisticsAdapter(this);
        gameReviewPresenter.getPlayByPlay(gameId);

    }

    @Override
    public void showToast(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPlayByPlay(PlayByPlay playByPlay) {
        this.playByPlay = playByPlay;
        Game game = playByPlay.getGame();
        awayScore.setText(String.valueOf(game.getAwayTeamRuns()));
        homeScore.setText(String.valueOf(game.getHomeTeamRuns()));
        for(GameStatus gameStatus : GameStatus.values()) {
            if (String.valueOf(gameStatus).equals(game.getStatus())) {
                textGameStatus.setText(gameStatus.getStatus());
            }
        }
        for(Teams team : Teams.values()) {
            if (String.valueOf(team).equals(game.getAwayTeam())) {
                awayIcon.setImageResource(team.getDrawableId());
            } else if (String.valueOf(team).equals(game.getHomeTeam())) {
                homeIcon.setImageResource(team.getDrawableId());
            }
        }
        if (game.getWinningPitcherId() != 0) {
            gameReviewPresenter.getPlayerGameStat(game.getDateTime(), game.getWinningPitcherId());
        }
        if (game.getSavingPitcherId() != 0) {
            gameReviewPresenter.getPlayerGameStat(game.getDateTime(), game.getSavingPitcherId());
        }
        onBindBoardView();
        onBindStatisticsView();

    }

    @Override
    public void setPlayerGameStat(PlayerStat playerGameStat) {
        this.playerGameStat = playerGameStat;
        if (playerGameStat.getPlayerId() == playByPlay.getGame().getWinningPitcherId()) {
            winningPitcherLabel.setText(R.string.winning_pitcher);
            winningPitcherText.setText(playerGameStat.getName());
        } else if (playerGameStat.getPlayerId() == playByPlay.getGame().getSavingPitcherId()) {
            savingPitcherLabel.setText(R.string.saving_pitcher);
            savingPitcherText.setText(playerGameStat.getName());
        }
    }

    private void onBindBoardView() {
        Game game = playByPlay.getGame();
        ArrayList<Inning> innings = game.getInnings();
        inningBoard.setNumColumns(innings.size() + 5);
        ArrayList<String> scoreBoards = new ArrayList<>();
        scoreBoards.add(""); // index 0
        for(Inning inning : innings) {
            scoreBoards.add(String.valueOf(inning.getInningNumber()));
        }
        scoreBoards.add("R");
        scoreBoards.add("H");
        scoreBoards.add("E");
        scoreBoards.add("B");
        scoreBoards.add(game.getAwayTeam()); //
        for (Inning inning : innings) {
            scoreBoards.add(String.valueOf(inning.getAwayTeamRuns()));
        }
        scoreBoards.add(String.valueOf(game.getAwayTeamRuns()));
        scoreBoards.add(String.valueOf(game.getAwayTeamHits()));
        scoreBoards.add(String.valueOf(game.getAwayTeamErrors()));
        scoreBoards.add(String.valueOf(countBases(game.getAwayTeamId())));
        scoreBoards.add(String.valueOf(game.getHomeTeam()));
        for(Inning inning : innings) {
            scoreBoards.add(String.valueOf(inning.getHomeTeamRuns()));
        }
        scoreBoards.add(String.valueOf(game.getHomeTeamRuns()));
        scoreBoards.add(String.valueOf(game.getHomeTeamHits()));
        scoreBoards.add(String.valueOf(game.getHomeTeamErrors()));
        scoreBoards.add(String.valueOf(countBases(game.getHomeTeamId())));

        gameReviewAdapter.setScoreBoards(scoreBoards);
        inningBoard.setAdapter(gameReviewAdapter);
    }
    private void onBindStatisticsView() {
        final Game game = playByPlay.getGame();
        ArrayList<String> stats = new ArrayList<>();

        stats.add(game.getAwayTeam());// index 0
        stats.add("통계");
        stats.add(game.getHomeTeam());
        stats.add(String.valueOf(game.getAwayTeamHits()));
        stats.add("안타");
        stats.add(String.valueOf(game.getHomeTeamHits())); // index 5
        addDetailStat(stats, game, "안타");
        stats.add(String.valueOf(countHomeRuns(game.getAwayTeamId())));
        stats.add("홈런");
        stats.add(String.valueOf(countHomeRuns(game.getHomeTeamId())));
        addDetailStat(stats, game, "홈런");
        stats.add(String.valueOf(countPitcherStrikeOut(game.getAwayTeamId())));
        stats.add("탈삼진");// index 10
        stats.add(String.valueOf(countPitcherStrikeOut(game.getHomeTeamId())));
        addDetailStat(stats, game, "탈삼진");
        stats.add(String.valueOf(countStolenBases(game.getAwayTeamId())));
        stats.add("도루");
        stats.add(String.valueOf(countStolenBases(game.getHomeTeamId())));
        addDetailStat(stats, game, "도루");
        stats.add(String.valueOf(game.getAwayTeamErrors())); // index 15
        stats.add("실책");
        stats.add(String.valueOf(game.getHomeTeamErrors()));// index 17
        addDetailStat(stats, game, "실책");

        stat.setAdapter(gameReviewStatisticsAdapter);
        gameReviewStatisticsAdapter.setStats(stats);
        gameReviewStatisticsAdapter.notifyDataSetChanged();

    }
    private int countBases(int teamId) {
        int count = 0;
        for (Play play : playByPlay.getPlays()) {
            if (play.getHitterTeamId() == teamId) {
                if (play.isWalk() ||
                        play.getResult().equals(getResources().getString(R.string.play_result_hit_by_pitch))) {
                    count++;
                }

            }
        }
        return count;
    }
    private int countStolenBases(int teamId) {
        int count = 0;
        for (Play play : playByPlay.getPlays()) {
            if (play.getHitterTeamId() == teamId
                    && play.getResult().equals(getResources().getString(R.string.play_result_stolen_base))) {
                count++;
            }
        }
        return count;
    }

    private int countHomeRuns(int teamId) {
        int count = 0;
        for (Play play : playByPlay.getPlays()) {
            if (play.getHitterTeamId() == teamId
                    && play.getResult().equals(getResources().getString(R.string.play_result_home_run))) {
                count++;
            }
        }
        return count;
    }

    private int countPitcherStrikeOut(int teamId) {
        int count = 0;
        for (Play play : playByPlay.getPlays()) {
            if (play.getPitcherTeamId() == teamId && play.isStrikeout()) {
                count++;
            }
        }
        return count;
    }
    private void addDetailStat(ArrayList<String> stats, Game game, String title) {
        Map<String, Integer> awayPlayer;
        Map<String, Integer> homePlayer;

        if (title.equals("안타")) {
            awayPlayer = getHitter(game.getAwayTeamId());
            homePlayer = getHitter(game.getHomeTeamId());
        } else if (title.equals("홈런")) {
            awayPlayer = getHomeRunner(game.getAwayTeamId());
            homePlayer = getHomeRunner(game.getHomeTeamId());
        } else if (title.equals("탈삼진")) {
            awayPlayer = getPitcher(game.getAwayTeamId());
            homePlayer = getPitcher(game.getHomeTeamId());
        } else if (title.equals("도루")) {
            awayPlayer = getBaseStealer(game.getAwayTeamId());
            homePlayer = getBaseStealer(game.getHomeTeamId());
        } else {
            awayPlayer = getDefender(game.getAwayTeamId());
            homePlayer = getDefender(game.getHomeTeamId());
        }
        if (awayPlayer.size() == 0 || homePlayer.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : awayPlayer.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" ");
            sb.append(entry.getValue());
            sb.append('\n');
        }

        stats.add(sb.toString());
        stats.add("");
        sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : homePlayer.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" ");
            sb.append(entry.getValue());
            sb.append('\n');
        }
        stats.add(sb.toString());

    }
    private Map<String, Integer> getHitter(int teamId) {
        Map<String, Integer> hitter = new TreeMap<>();
        for (Play play : playByPlay.getPlays()) {
            if (play.isHit()) {
                if (play.getHitterTeamId() == teamId) {
                    hitter.put(play.getHitterName(), hitter.getOrDefault(play.getHitterName() + 1, 1));
                }
            }
        }
        return hitter;
    }
    private Map<String, Integer> getHomeRunner(int teamId) {
        Map<String, Integer> player = new TreeMap<>();
        for (Play play : playByPlay.getPlays()) {
            if (play.getResult().equals(getString(R.string.play_result_home_run))) {
                if (play.getHitterTeamId() == teamId) {
                    player.put(play.getHitterName(), player.getOrDefault(play.getHitterName() + 1, 1));
                }
            }
        }
        return player;
    }
    private Map<String, Integer> getBaseStealer(int teamId) {
        Map<String, Integer> player = new TreeMap<>();
        for (Play play : playByPlay.getPlays()) {
            if (play.getResult().equals(getString(R.string.play_result_stolen_base))) {
                if (play.getHitterTeamId() == teamId) {
                    player.put(play.getHitterName(), player.getOrDefault(play.getHitterName() + 1, 1));
                }
            }
        }
        return player;
    }
    private Map<String, Integer> getDefender(int teamId) {
        Map<String, Integer> player = new TreeMap<>();
        for (Play play : playByPlay.getPlays()) {
            if (play.getResult().equals(getString(R.string.play_result_error))) {
                if (play.getHitterTeamId() == teamId) {
                    player.put(play.getHitterName(), player.getOrDefault(play.getHitterName() + 1, 1));
                }
            }
        }
        return player;
    }
    private Map<String, Integer> getPitcher(int teamId) {
        Map<String, Integer> player = new TreeMap<>();
        for (Play play : playByPlay.getPlays()) {
            if (play.isStrikeout()) {
                if (play.getPitcherId() == teamId) {
                    player.put(play.getPitcherName(), player.getOrDefault(play.getPitcherName() + 1, 1));
                }
            }
        }
        return player;
    }
}
