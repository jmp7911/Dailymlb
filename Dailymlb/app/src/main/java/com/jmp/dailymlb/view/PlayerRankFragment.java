package com.jmp.dailymlb.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.model.PlayerStat;
import com.jmp.dailymlb.presenter.PlayerRankContract;
import com.jmp.dailymlb.presenter.PlayerRankPresenter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PlayerRankFragment extends Fragment implements PlayerRankContract.View {
    View view;
    PlayerRankPresenter playerRankPresenter;
    List<PlayerStat> playerStats;
    Button btnBatterRank;
    Button btnPitcherRank;
    TableLayout tableAverage;
    TableLayout tableHomeRunOrWinning;
    TableLayout tableRunBattedInOrPitcherStrikeOut;
    TableLayout tableStolenBaseOrSaving;
    TableLayout tableOpsOrWhip;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (playerRankPresenter != null) {
            playerRankPresenter.detachView();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_season_player_rank, container, false);
        btnBatterRank = view.findViewById(R.id.player_rank_batter);
        btnPitcherRank = view.findViewById(R.id.player_rank_pitcher);
        tableAverage = view.findViewById(R.id.player_rank_average);
        tableHomeRunOrWinning = view.findViewById(R.id.player_rank_home_run_or_winning);
        tableRunBattedInOrPitcherStrikeOut = view.findViewById(R.id.player_rank_run_batted_in_or_pitcher_strike_out);
        tableStolenBaseOrSaving = view.findViewById(R.id.player_rank_stolen_base_or_saving);
        tableOpsOrWhip = view.findViewById(R.id.player_rank_ops_or_whip);
        playerRankPresenter = new PlayerRankPresenter();
        playerRankPresenter.attachView(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        playerRankPresenter.getPlayerStats(new Date());
        btnBatterRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBatterRank();
            }
        });
        btnPitcherRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPitcherRank();
            }
        });
    }

    @Override
    public void showToast(String title) {
        Toast.makeText(getContext(), title, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPlayerStats(List<PlayerStat> playerStats) {
        this.playerStats = playerStats;
        if (playerStats.isEmpty()) {
            return;
        }

    }
    private void showBatterRank() {
        clearTables();
        onBindTableLayout(tableAverage, getTOP5PlayerStats(R.string.batting_average), R.string.batting_average);
        onBindTableLayout(tableHomeRunOrWinning, getTOP5PlayerStats(R.string.home_run), R.string.home_run);
        onBindTableLayout(tableRunBattedInOrPitcherStrikeOut, getTOP5PlayerStats(R.string.runs_batted_in), R.string.runs_batted_in);
        onBindTableLayout(tableStolenBaseOrSaving, getTOP5PlayerStats(R.string.stolen_base), R.string.stolen_base);
        onBindTableLayout(tableOpsOrWhip, getTOP5PlayerStats(R.string.on_base_plus_slugging), R.string.on_base_plus_slugging);
    }
    private void showPitcherRank() {
        clearTables();
        onBindTableLayout(tableAverage, getTOP5PlayerStats(R.string.earned_runs_average), R.string.earned_runs_average);
        onBindTableLayout(tableHomeRunOrWinning, getTOP5PlayerStats(R.string.winning), R.string.winning);
        onBindTableLayout(tableRunBattedInOrPitcherStrikeOut, getTOP5PlayerStats(R.string.pitcher_strike_out), R.string.pitcher_strike_out);
        onBindTableLayout(tableStolenBaseOrSaving, getTOP5PlayerStats(R.string.saving), R.string.saving);
        onBindTableLayout(tableOpsOrWhip, getTOP5PlayerStats(R.string.walks_hits_per_innings_pitched), R.string.walks_hits_per_innings_pitched);
    }
    private void clearTables() {
        tableAverage.removeAllViews();
        tableHomeRunOrWinning.removeAllViews();
        tableRunBattedInOrPitcherStrikeOut.removeAllViews();
        tableStolenBaseOrSaving.removeAllViews();
        tableOpsOrWhip.removeAllViews();
    }
    private void onBindTableLayout(TableLayout tableLayout, List<PlayerStat> TOP5PlayerStats, int resId) {
        TableRow title = new TableRow(getContext());
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        title.setLayoutParams(layoutParams);
        tableLayout.addView(title);
        title.addView(new TextView(getContext()));
        TextView textView = (TextView)title.getChildAt(0);
        textView.setText(resId);
        int[] rank = getRank(TOP5PlayerStats, resId);
        for(int i = 0; i < 5; i++) {
            TableRow row = new TableRow(getContext());
            row.setLayoutParams(layoutParams);
            tableLayout.addView(row);
            TextView column1 = new TextView(getContext());
            row.addView(column1);
            column1.setText(String.valueOf(rank[i]));
            TextView column2 = new TextView(getContext());
            row.addView(column2);
            column2.setText(TOP5PlayerStats.get(i).getName());
            TextView column3 = new TextView(getContext());
            row.addView(column3);
            column3.setText(TOP5PlayerStats.get(i).getTeam());
            TextView column4 = new TextView(getContext());
            row.addView(column4);
            if (resId == R.string.batting_average) {
                column4.setText(String.valueOf(TOP5PlayerStats.get(i).getAvg()));
            } else if (resId == R.string.home_run) {
                column4.setText(String.valueOf(TOP5PlayerStats.get(i).getHomeRuns()));
            } else if (resId == R.string.hit) {
                column4.setText(String.valueOf(TOP5PlayerStats.get(i).getHits()));
            } else if (resId == R.string.runs_batted_in) {
                column4.setText(String.valueOf(TOP5PlayerStats.get(i).getRunsBattedIn()));
            } else if (resId == R.string.stolen_base) {
                column4.setText(String.valueOf(TOP5PlayerStats.get(i).getStolenBases()));
            } else if (resId == R.string.on_base_plus_slugging) {
                column4.setText(String.valueOf(TOP5PlayerStats.get(i).getOps()));
            } else if (resId == R.string.earned_runs_average) {
                column4.setText(String.valueOf(TOP5PlayerStats.get(i).getEra()));
            } else if (resId == R.string.winning) {
                column4.setText(String.valueOf(TOP5PlayerStats.get(i).getWins()));
            } else if (resId == R.string.saving) {
                column4.setText(String.valueOf(TOP5PlayerStats.get(i).getSaves()));
            } else if (resId == R.string.pitcher_strike_out) {
                column4.setText(String.valueOf(TOP5PlayerStats.get(i).getPitchingStrikeout()));
            } else if (resId == R.string.walks_hits_per_innings_pitched) {
                column4.setText(String.valueOf(TOP5PlayerStats.get(i).getWhip()));
            }
        }

    }
    private int[] getRank(List<PlayerStat> TOP5PlayerStats, int resId) {
        int[] rank = new int[TOP5PlayerStats.size()];
        for(int i = 0; i < TOP5PlayerStats.size(); i++) {
            rank[i] = 1;
            for(int j = 0; j < TOP5PlayerStats.size(); j++) {
                if (resId == R.string.batting_average && TOP5PlayerStats.get(i).getAvg() < TOP5PlayerStats.get(j).getAvg()) {
                    rank[i]++;
                } else if (resId == R.string.home_run &&
                        TOP5PlayerStats.get(i).getHomeRuns() < TOP5PlayerStats.get(j).getHomeRuns()) {
                    rank[i]++;
                } else if (resId == R.string.runs_batted_in && TOP5PlayerStats.get(i).getRunsBattedIn() < TOP5PlayerStats.get(j).getRunsBattedIn()) {
                    rank[i]++;
                } else if (resId == R.string.stolen_base && TOP5PlayerStats.get(i).getStolenBases() < TOP5PlayerStats.get(j).getStolenBases()) {
                    rank[i]++;
                } else if (resId == R.string.on_base_plus_slugging && TOP5PlayerStats.get(i).getOps() < TOP5PlayerStats.get(j).getOps()) {
                    rank[i]++;
                } else if (resId == R.string.earned_runs_average && TOP5PlayerStats.get(i).getEra() < TOP5PlayerStats.get(j).getEra()) {
                    rank[i]++;
                } else if (resId == R.string.winning && TOP5PlayerStats.get(i).getWins() < TOP5PlayerStats.get(j).getWins()) {
                    rank[i]++;
                } else if (resId == R.string.saving && TOP5PlayerStats.get(i).getSaves() < TOP5PlayerStats.get(j).getSaves()) {
                    rank[i]++;
                } else if (resId == R.string.pitcher_strike_out && TOP5PlayerStats.get(i).getPitchingStrikeout() < TOP5PlayerStats.get(j).getPitchingStrikeout()) {
                    rank[i]++;
                } else if (resId == R.string.walks_hits_per_innings_pitched && TOP5PlayerStats.get(i).getWhip() < TOP5PlayerStats.get(j).getWhip()) {
                    rank[i]++;
                }
            }
        }
        return rank;
    }
    private List<PlayerStat> getTOP5PlayerStats(int resId) {
        List<PlayerStat> TOP5PlayerStat = new ArrayList<>();
        if (resId == R.string.batting_average) {
            playerStats.sort(new Comparator<PlayerStat>() {
                @Override
                public int compare(PlayerStat playerStat, PlayerStat t1) {
                    if (playerStat.getAvg() > t1.getAvg()) {
                        return -1;
                    } else if (playerStat.getAvg() == t1.getAvg()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
            TOP5PlayerStat = playerStats.subList(0, 5);
        } else if (resId == R.string.home_run) {
            playerStats.sort(new Comparator<PlayerStat>() {
                @Override
                public int compare(PlayerStat playerStat, PlayerStat t1) {
                    if (playerStat.getHomeRuns() > t1.getHomeRuns()) {
                        return -1;
                    } else if (playerStat.getHomeRuns() == t1.getHomeRuns()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
            TOP5PlayerStat = playerStats.subList(0, 5);
        } else if (resId == R.string.runs_batted_in) {
            playerStats.sort(new Comparator<PlayerStat>() {
                @Override
                public int compare(PlayerStat playerStat, PlayerStat t1) {
                    if (playerStat.getRunsBattedIn() > t1.getRunsBattedIn()) {
                        return -1;
                    } else if (playerStat.getRunsBattedIn() == t1.getRunsBattedIn()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
            TOP5PlayerStat = playerStats.subList(0, 5);
        } else if (resId == R.string.stolen_base) {
            playerStats.sort(new Comparator<PlayerStat>() {
                @Override
                public int compare(PlayerStat playerStat, PlayerStat t1) {
                    if (playerStat.getStolenBases() > t1.getStolenBases()) {
                        return -1;
                    } else if (playerStat.getStolenBases() == t1.getStolenBases()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
            TOP5PlayerStat = playerStats.subList(0, 5);
        } else if (resId == R.string.on_base_plus_slugging) {
            playerStats.sort(new Comparator<PlayerStat>() {
                @Override
                public int compare(PlayerStat playerStat, PlayerStat t1) {
                    if (playerStat.getOps() > t1.getOps()) {
                        return -1;
                    } else if (playerStat.getOps() == t1.getOps()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
            TOP5PlayerStat = playerStats.subList(0, 5);
        } else if (resId == R.string.earned_runs_average) {
            playerStats.sort(new Comparator<PlayerStat>() {
                @Override
                public int compare(PlayerStat playerStat, PlayerStat t1) {
                    if (playerStat.getEra() > t1.getEra()) {
                        return 1;
                    } else if (playerStat.getEra() == t1.getEra()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
            TOP5PlayerStat = playerStats.subList(0, 5);
        } else if (resId == R.string.winning) {
            playerStats.sort(new Comparator<PlayerStat>() {
                @Override
                public int compare(PlayerStat playerStat, PlayerStat t1) {
                    if (playerStat.getWins() > t1.getWins()) {
                        return -1;
                    } else if (playerStat.getWins() == t1.getWins()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
            TOP5PlayerStat = playerStats.subList(0, 5);
        } else if (resId == R.string.saving) {
            playerStats.sort(new Comparator<PlayerStat>() {
                @Override
                public int compare(PlayerStat playerStat, PlayerStat t1) {
                    if (playerStat.getSaves() > t1.getSaves()) {
                        return -1;
                    } else if (playerStat.getSaves() == t1.getSaves()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
            TOP5PlayerStat = playerStats.subList(0, 5);
        } else if (resId == R.string.pitcher_strike_out) {
            playerStats.sort(new Comparator<PlayerStat>() {
                @Override
                public int compare(PlayerStat playerStat, PlayerStat t1) {
                    if (playerStat.getPitchingStrikeout() > t1.getPitchingStrikeout()) {
                        return -1;
                    } else if (playerStat.getPitchingStrikeout() == t1.getPitchingStrikeout()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
            TOP5PlayerStat = playerStats.subList(0, 5);
        } else if (resId == R.string.walks_hits_per_innings_pitched) {
            playerStats.sort(new Comparator<PlayerStat>() {
                @Override
                public int compare(PlayerStat playerStat, PlayerStat t1) {
                    if (!playerStat.getPositionCategory().equals("P")) {
                        return 1;
                    }
                    if (playerStat.getWhip() > t1.getWhip()) {
                        return 1;
                    } else if (playerStat.getWhip() == t1.getWhip()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
            TOP5PlayerStat = playerStats.subList(0, 5);
        }
        return TOP5PlayerStat;
    }
}
