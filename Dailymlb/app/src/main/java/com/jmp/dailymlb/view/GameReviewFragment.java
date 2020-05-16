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
import java.util.Map;
import java.util.TreeMap;

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
    float scale;
    int startDP;

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
        this.scale = context.getResources().getDisplayMetrics().density;
        this.startDP = (int) scale;
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
        GameReviewWrapper wrapper = (GameReviewWrapper) view.getTag();

        wrapper.getAwayScore().setText(String.valueOf(playByPlay.getGame().getAwayTeamRuns()));
        wrapper.getReviewStatus().setText(playByPlay.getGame().getStatus());
        wrapper.getHomeScore().setText(String.valueOf(playByPlay.getGame().getHomeTeamRuns()));
        for (Teams team : Teams.values()) {
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

        for (Inning inning : innings) {
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

        TableRow.LayoutParams layoutParams = (TableRow.LayoutParams) blankTextView.getLayoutParams();
        layoutParams.setMarginStart(startDP);
        blankTextView.setLayoutParams(layoutParams);
        layoutParams = (TableRow.LayoutParams) awayTeam.getLayoutParams();
        layoutParams.setMarginStart(startDP);
        awayTeam.setLayoutParams(layoutParams);
        layoutParams = (TableRow.LayoutParams) homeTeam.getLayoutParams();
        layoutParams.setMarginStart(startDP);
        homeTeam.setLayoutParams(layoutParams);

        awayTeam.setText(playByPlay.getGame().getAwayTeam());
        homeTeam.setText(playByPlay.getGame().getHomeTeam());

    }

    private void addBoardColumn(TableRow row1, String text1, TableRow row2, String text2, TableRow row3, String text3) {
        float scale = context.getResources().getDisplayMetrics().density;
        int startDP = (int) scale;

        TextView view1 = new TextView(context);
        row1.addView(view1);
        TableRow.LayoutParams layoutParams = (TableRow.LayoutParams) view1.getLayoutParams();
        layoutParams.setMarginStart(startDP);
        layoutParams.width = startDP * 20;
        view1.setLayoutParams(layoutParams);
        view1.setText(text1);
        view1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        view1.setBackgroundColor(ContextCompat.getColor(context, R.color.color1));

        TextView view2 = new TextView(context);
        row2.addView(view2);
        layoutParams = (TableRow.LayoutParams) view2.getLayoutParams();
        layoutParams.width = startDP * 20;
        layoutParams.setMarginStart(startDP);
        view2.setLayoutParams(layoutParams);
        view2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        view2.setText(text2);
        view2.setBackgroundColor(ContextCompat.getColor(context, R.color.color2));

        TextView view3 = new TextView(context);
        row3.addView(view3);
        layoutParams = (TableRow.LayoutParams) view3.getLayoutParams();
        layoutParams.width = startDP * 20;
        layoutParams.setMarginStart(startDP);
        view3.setLayoutParams(layoutParams);
        view3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        view3.setText(text3);
        view3.setBackgroundColor(ContextCompat.getColor(context, R.color.color3));

    }

    private String countBases(int teamId) {
        int count = 0;
        for (Play play : playByPlay.getPlays()) {
            if (play.getHitterTeamId() == teamId) {
                if (play.isWalk() ||
                        play.getResult().equals(getResources().getString(R.string.play_result_hit_by_pitch))) {
                    count++;
                }

            }
        }
        return String.valueOf(count);
    }

    private void bindOnStatistics(GameReviewWrapper wrapper) {
        Game game = playByPlay.getGame();
        setTableStatistics(wrapper.getTableHit(), game.getAwayTeamHits(), game.getHomeTeamHits(),
                game.getAwayTeamId(), game.getHomeTeamId());
        setTableStatistics(wrapper.getTableHomeRun(), countHomeRuns(game.getAwayTeamId()),
                countHomeRuns(game.getHomeTeamId()), game.getAwayTeamId(), game.getHomeTeamId());
        setTableStatistics(wrapper.getTableStolenBase(), countStolenBases(game.getAwayTeamId()),
                countStolenBases(game.getHomeTeamId()), game.getAwayTeamId(), game.getHomeTeamId());
        setTableStatistics(wrapper.getTablePitcherStrikeOut(), countPitcherStrikeOut(game.getAwayTeamId()),
                countPitcherStrikeOut(game.getHomeTeamId()), game.getAwayTeamId(), game.getHomeTeamId());
        setTableStatistics(wrapper.getTableError(), game.getAwayTeamErrors(), game.getHomeTeamErrors(),
                game.getAwayTeamId(), game.getHomeTeamId());
    }
    private void setTableStatistics(final TableLayout tableLayout, int awayData, int homeData, final int awayTeamId, final int homeTeamId) {
        TableRow row = (TableRow)tableLayout.getChildAt(0);
        TextView awayView = (TextView)row.getChildAt(0);
        final TextView titleView = (TextView)row.getChildAt(1);
        TextView homeView = (TextView)row.getChildAt(2);

        awayView.setText(String.valueOf(awayData));
        homeView.setText(String.valueOf(homeData));

        if (awayData > 0 || homeData > 0) {
            titleView.setBackgroundResource(R.drawable.hide);
            titleView.setTag(false);
            titleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ((boolean)view.getTag()) {
                        view.setTag(false);
                        removeRow(tableLayout);
                        view.setBackgroundResource(R.drawable.hide);
                    } else {
                        view.setTag(true);
                        view.setBackgroundResource(R.drawable.visible);
                    }
                    if ((boolean)view.getTag()) {
                        if (titleView.getText().equals("안타")) {
                            addRowDetail(tableLayout, getHitter(awayTeamId), getHitter(homeTeamId));
                        } else if (titleView.getText().equals("홈런")) {
                            addRowDetail(tableLayout, getHomeRunner(awayTeamId), getHomeRunner(homeTeamId));
                        } else if (titleView.getText().equals("탈삼진")) {
                            addRowDetail(tableLayout, getPitcher(awayTeamId), getPitcher(homeTeamId));
                        } else if (titleView.getText().equals("도루")) {
                            addRowDetail(tableLayout, getBaseStealer(awayTeamId), getBaseStealer(homeTeamId));
                        } else if (titleView.getText().equals("실책")) {
                            addRowDetail(tableLayout, getDefender(awayTeamId), getDefender(homeTeamId));
                        }
                    }
                }
            });
        }

    }

    private void removeRow(TableLayout tableLayout) {
        while(tableLayout.getChildCount() > 1) {
            tableLayout.removeViewAt(tableLayout.getChildCount() - 1);
        }
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
    private void addRowDetail(TableLayout tableLayout, Map<String, Integer> awayPlayer, Map<String, Integer> homePlayer) {

        int length = Math.max(awayPlayer.size(), homePlayer.size());
        for (int i = 0; i < length; i++) {
            TableRow playerRow = new TableRow(context);
            TableRow.LayoutParams tableRowLayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            playerRow.setLayoutParams(tableRowLayoutParams);
            tableLayout.addView(playerRow, tableLayout.getChildCount());
        }
        int statHitIndex = tableLayout.getChildCount() - length;
        for (Map.Entry<String, Integer> awayHitterEntry : awayPlayer.entrySet()) {
            String text = awayHitterEntry.getKey() + " " + awayHitterEntry.getValue();
            TableRow playerRow = (TableRow) tableLayout.getChildAt(statHitIndex++);
            TextView playerView = new TextView(context);
            playerRow.addView(playerView);
            playerView.setText(text);
            playerView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        }
        if (awayPlayer.size() < homePlayer.size()) {
            for(int i = awayPlayer.size() + 1; i < tableLayout.getChildCount(); i++) {
                TextView blankView = new TextView(context);
                TableRow playerRow = (TableRow) tableLayout.getChildAt(i);
                playerRow.addView(blankView);
            }
        }
        statHitIndex = tableLayout.getChildCount() - length;
        for (int i = statHitIndex; i < tableLayout.getChildCount(); i++) {
            TextView blankView = new TextView(context);
            TableRow playerRow = (TableRow) tableLayout.getChildAt(i);
            playerRow.addView(blankView);
        }

        statHitIndex = tableLayout.getChildCount() - length;
        for (Map.Entry<String, Integer> homeHitterEntry : homePlayer.entrySet()) {
            String text = homeHitterEntry.getKey() + " " + homeHitterEntry.getValue();
            TableRow playerRow = (TableRow) tableLayout.getChildAt(statHitIndex++);
            TextView PlayerView = new TextView(context);
            playerRow.addView(PlayerView);
            PlayerView.setText(text);
            PlayerView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        }
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

    @Override
    public void showToast(String title) {
        Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
    }

}
