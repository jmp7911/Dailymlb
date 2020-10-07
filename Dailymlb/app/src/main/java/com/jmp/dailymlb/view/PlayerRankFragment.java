package com.jmp.dailymlb.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.model.PlayerStat;
import com.jmp.dailymlb.model.Team;
import com.jmp.dailymlb.model.TeamStat;
import com.jmp.dailymlb.presenter.PlayerRankContract;
import com.jmp.dailymlb.presenter.PlayerRankPresenter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

public class PlayerRankFragment extends Fragment implements PlayerRankContract.View {
    View view;
    PlayerRankPresenter playerRankPresenter;
    List<PlayerStat> playerStats;
    List<TeamStat> teamStats;
    List<Team> teams;
    Button btnAmericanLeagueBatterRank;
    Button btnAmericanLeaguePitcherRank;
    Button btnNationalLeagueBatterRank;
    Button btnNationalLeaguePitcherRank;
    GridView gridViewAverage;
    GridView gridViewHomeRunOrWinning;
    GridView gridViewRunBattedInOrPitcherStrikeOut;
    GridView gridViewStolenBaseOrSaving;
    GridView gridViewOpsOrWhip;
    TextView averageText;
    TextView homeRunOrWinningText;
    TextView runBattedInOrPitcherStrikeOutText;
    TextView stolenBaseOrSavingText;
    TextView opsOrWhipText;
    ProgressDialog progressDialog;
    public PlayerRankFragment() {
        view = null;
        playerRankPresenter = null;
        playerStats = new ArrayList<>();
        teamStats = new ArrayList<>();
        teams = new ArrayList<>();
        btnAmericanLeagueBatterRank = null;
        btnAmericanLeaguePitcherRank = null;
        gridViewAverage = null;
        gridViewHomeRunOrWinning = null;
        gridViewRunBattedInOrPitcherStrikeOut = null;
        gridViewStolenBaseOrSaving = null;
        gridViewOpsOrWhip = null;
        averageText = null;
        homeRunOrWinningText = null;
        runBattedInOrPitcherStrikeOutText = null;
        stolenBaseOrSavingText = null;
        opsOrWhipText = null;
        progressDialog = null;
    }

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
        btnAmericanLeagueBatterRank = view.findViewById(R.id.player_rank_american_league_batter);
        btnAmericanLeaguePitcherRank = view.findViewById(R.id.player_rank_american_league_pitcher);
        btnNationalLeagueBatterRank = view.findViewById(R.id.player_rank_national_league_batter);
        btnNationalLeaguePitcherRank = view.findViewById(R.id.player_rank_national_league_pitcher);
        gridViewAverage = view.findViewById(R.id.player_rank_average);
        gridViewHomeRunOrWinning = view.findViewById(R.id.player_rank_home_run_or_winning);
        gridViewRunBattedInOrPitcherStrikeOut = view.findViewById(R.id.player_rank_run_batted_in_or_pitcher_strike_out);
        gridViewStolenBaseOrSaving = view.findViewById(R.id.player_rank_stolen_base_or_saving);
        gridViewOpsOrWhip = view.findViewById(R.id.player_rank_ops_or_whip);
        averageText = view.findViewById(R.id.player_rank_average_text);
        homeRunOrWinningText = view.findViewById(R.id.player_rank_home_run_or_winning_text);
        runBattedInOrPitcherStrikeOutText = view.findViewById(R.id.player_rank_run_batted_in_or_pitcher_strike_out_text);
        stolenBaseOrSavingText = view.findViewById(R.id.player_rank_stolen_base_or_saving_text);
        opsOrWhipText = view.findViewById(R.id.player_rank_ops_or_whip_text);
        progressDialog = new ProgressDialog(getContext());
        playerRankPresenter = new PlayerRankPresenter();
        playerRankPresenter.attachView(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        progressDialog.setProgressStyle(R.style.Theme_Design_NoActionBar);
        progressDialog.setCancelable(false);
        progressDialog.show();
        playerRankPresenter.getPlayerStats(new Date());
        playerRankPresenter.getTeamStats(new Date());
        playerRankPresenter.getTeams();
        btnAmericanLeagueBatterRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBatterRank(R.string.american_league);
            }
        });
        btnAmericanLeaguePitcherRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPitcherRank(R.string.american_league);
            }
        });
        btnNationalLeagueBatterRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBatterRank(R.string.national_league);
            }
        });
        btnNationalLeaguePitcherRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPitcherRank(R.string.national_league);
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
    }

    @Override
    public void setTeamStats(List<TeamStat> teamStats) {
        this.teamStats = teamStats;
    }

    @Override
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public void dismiss() {
        progressDialog.dismiss();
    }

    private void showBatterRank(int league) {
        if (playerStats == null) {
            Toast.makeText(getContext(), "정보를 불러오고 있습니다. 조금만 기다려주세요", Toast.LENGTH_SHORT).show();
            return;
        } else if (playerStats.size() == 0) {
            Toast.makeText(getContext(), "정보를 불러오고 있습니다. 조금만 기다려주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        averageText.setText(R.string.batting_average);
        homeRunOrWinningText.setText(R.string.home_run);
        runBattedInOrPitcherStrikeOutText.setText(R.string.runs_batted_in);
        stolenBaseOrSavingText.setText(R.string.stolen_base);
        opsOrWhipText.setText(R.string.on_base_plus_slugging);
        setPlayerRankAdapter(gridViewAverage, getSortedPlayerStats(R.string.batting_average, league), R.string.batting_average);
        setPlayerRankAdapter(gridViewHomeRunOrWinning, getSortedPlayerStats(R.string.home_run, league), R.string.home_run);
        setPlayerRankAdapter(gridViewRunBattedInOrPitcherStrikeOut, getSortedPlayerStats(R.string.runs_batted_in, league), R.string.runs_batted_in);
        setPlayerRankAdapter(gridViewStolenBaseOrSaving, getSortedPlayerStats(R.string.stolen_base, league), R.string.stolen_base);
        setPlayerRankAdapter(gridViewOpsOrWhip, getSortedPlayerStats(R.string.on_base_plus_slugging, league), R.string.on_base_plus_slugging);
    }
    private void showPitcherRank(int league) {
        averageText.setText(R.string.earned_runs_average);
        homeRunOrWinningText.setText(R.string.winning);
        runBattedInOrPitcherStrikeOutText.setText(R.string.pitcher_strike_out);
        stolenBaseOrSavingText.setText(R.string.saving);
        opsOrWhipText.setText(R.string.walks_hits_per_innings_pitched);
        setPlayerRankAdapter(gridViewAverage, getSortedPlayerStats(R.string.earned_runs_average, league), R.string.earned_runs_average);
        setPlayerRankAdapter(gridViewHomeRunOrWinning, getSortedPlayerStats(R.string.winning, league), R.string.winning);
        setPlayerRankAdapter(gridViewRunBattedInOrPitcherStrikeOut, getSortedPlayerStats(R.string.pitcher_strike_out, league), R.string.pitcher_strike_out);
        setPlayerRankAdapter(gridViewStolenBaseOrSaving, getSortedPlayerStats(R.string.saving, league), R.string.saving);
        setPlayerRankAdapter(gridViewOpsOrWhip, getSortedPlayerStats(R.string.walks_hits_per_innings_pitched, league), R.string.walks_hits_per_innings_pitched);
    }

    private void setPlayerRankAdapter(GridView container, List<PlayerStat> sortedPlayerStats, int title) {
        List<String> playerRanks = new ArrayList<>();
        int[] rank = getRank(sortedPlayerStats, title);
        for(int i = 0; i < rank.length; i++) {
            playerRanks.add(String.valueOf(rank[i]));
            playerRanks.add(sortedPlayerStats.get(i).getName());
            playerRanks.add(sortedPlayerStats.get(i).getTeam());

            if (title == R.string.batting_average) {
                playerRanks.add(String.valueOf(sortedPlayerStats.get(i).getAvg()));
            } else if (title == R.string.home_run) {
                playerRanks.add(String.valueOf(sortedPlayerStats.get(i).getHomeRuns()));
            } else if (title == R.string.hit) {
                playerRanks.add(String.valueOf(sortedPlayerStats.get(i).getHits()));
            } else if (title == R.string.runs_batted_in) {
                playerRanks.add(String.valueOf(sortedPlayerStats.get(i).getRunsBattedIn()));
            } else if (title == R.string.stolen_base) {
                playerRanks.add(String.valueOf(sortedPlayerStats.get(i).getStolenBases()));
            } else if (title == R.string.on_base_plus_slugging) {
                playerRanks.add(String.valueOf(sortedPlayerStats.get(i).getOps()));
            } else if (title == R.string.earned_runs_average) {
                playerRanks.add(String.valueOf(sortedPlayerStats.get(i).getEra()));
            } else if (title == R.string.winning) {
                playerRanks.add(String.valueOf(sortedPlayerStats.get(i).getWins()));
            } else if (title == R.string.saving) {
                playerRanks.add(String.valueOf(sortedPlayerStats.get(i).getSaves()));
            } else if (title == R.string.pitcher_strike_out) {
                playerRanks.add(String.valueOf(sortedPlayerStats.get(i).getPitchingStrikeout()));
            } else if (title == R.string.walks_hits_per_innings_pitched) {
                playerRanks.add(String.valueOf(sortedPlayerStats.get(i).getWhip()));
            }
        }
        PlayerRankAdapter playerRankAdapter = new PlayerRankAdapter(getContext());
        playerRankAdapter.setPlayerStats(playerRanks);
        container.setAdapter(playerRankAdapter);
    }
    private int[] getRank(List<PlayerStat> sortedPlayerStats, int resId) {

        int count = Math.min(5, sortedPlayerStats.size());
        int[] rank = new int[count];
        for(int i = 0; i < count; i++) {
            rank[i] = 1;
            for(int j = 0; j < count; j++) {
                if (resId == R.string.batting_average && sortedPlayerStats.get(i).getAvg() < sortedPlayerStats.get(j).getAvg()) {
                    rank[i]++;
                } else if (resId == R.string.on_base_plus_slugging && sortedPlayerStats.get(i).getOps() < sortedPlayerStats.get(j).getOps()) {
                    rank[i]++;
                } else if (resId == R.string.home_run && sortedPlayerStats.get(i).getHomeRuns() < sortedPlayerStats.get(j).getHomeRuns()) {
                    rank[i]++;
                } else if (resId == R.string.runs_batted_in && sortedPlayerStats.get(i).getRunsBattedIn() < sortedPlayerStats.get(j).getRunsBattedIn()) {
                    rank[i]++;
                } else if (resId == R.string.stolen_base && sortedPlayerStats.get(i).getStolenBases() < sortedPlayerStats.get(j).getStolenBases()) {
                    rank[i]++;
                } else if (resId == R.string.winning && sortedPlayerStats.get(i).getWins() < sortedPlayerStats.get(j).getWins()) {
                    rank[i]++;
                } else if (resId == R.string.saving && sortedPlayerStats.get(i).getSaves() < sortedPlayerStats.get(j).getSaves()) {
                    rank[i]++;
                } else if (resId == R.string.pitcher_strike_out && sortedPlayerStats.get(i).getPitchingStrikeout() < sortedPlayerStats.get(j).getPitchingStrikeout()) {
                    rank[i]++;
                } else if (resId == R.string.earned_runs_average && sortedPlayerStats.get(i).getEra() > sortedPlayerStats.get(j).getEra()) {
                    rank[i]++;
                } else if (resId == R.string.walks_hits_per_innings_pitched && sortedPlayerStats.get(i).getWhip() > sortedPlayerStats.get(j).getWhip()) {
                    rank[i]++;
                }
            }
        }

        return rank;
    }
    private List<PlayerStat> getSortedPlayerStats(int title, int league) {

        if (title == R.string.batting_average) {
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
            List<PlayerStat> sortedPlayerStats = new ArrayList<>();
            for(int i = 0; i < playerStats.size(); i++) {
                for(TeamStat teamStat : teamStats) {
                    if (teamStat.getTeam().equals(playerStats.get(i).getTeam())) {
                        if (playerStats.get(i).getAtBats() >= teamStat.getGames() * 3) {
                            for(Team team : teams) {
                                if (team.getTeam().equals(teamStat.getTeam()) && team.getLeague().equals(getString(league))) {
                                    sortedPlayerStats.add(playerStats.get(i));
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }
            return sortedPlayerStats;
        } else if (title == R.string.home_run) {
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
        } else if (title == R.string.runs_batted_in) {
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
        } else if (title == R.string.stolen_base) {
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
        } else if (title == R.string.on_base_plus_slugging) {
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
            List<PlayerStat> sortedPlayerStats = new ArrayList<>();
            for(int i = 0; i < playerStats.size(); i++) {
                for(TeamStat teamStat : teamStats) {
                    if (teamStat.getTeam().equals(playerStats.get(i).getTeam())) {
                        if (playerStats.get(i).getAtBats() >= teamStat.getGames() * 3) {
                            for(Team team : teams) {
                                if (team.getTeam().equals(teamStat.getTeam()) && team.getLeague().equals(getString(league))) {
                                    sortedPlayerStats.add(playerStats.get(i));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return sortedPlayerStats;
        } else if (title == R.string.earned_runs_average) {
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
            List<PlayerStat> sortedPlayerStats = new ArrayList<>();
            for(int i = 0; i < playerStats.size(); i++) {
                for(TeamStat teamStat : teamStats) {
                    if (teamStat.getTeam().equals(playerStats.get(i).getTeam())) {
                        if (playerStats.get(i).getInningsPitched() >= teamStat.getGames()) {
                            for(Team team : teams) {
                                if (team.getTeam().equals(teamStat.getTeam()) && team.getLeague().equals(getString(league))) {
                                    sortedPlayerStats.add(playerStats.get(i));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return sortedPlayerStats;
        } else if (title == R.string.winning) {
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
        } else if (title == R.string.saving) {
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
        } else if (title == R.string.pitcher_strike_out) {
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
        } else if (title == R.string.walks_hits_per_innings_pitched) {
            playerStats.sort(new Comparator<PlayerStat>() {
                @Override
                public int compare(PlayerStat playerStat, PlayerStat t1) {
                    if (playerStat.getWhip() > t1.getWhip()) {
                        return 1;
                    } else if (playerStat.getWhip() == t1.getWhip()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
            List<PlayerStat> sortedPlayerStats = new ArrayList<>();
            for(int i = 0; i < playerStats.size(); i++) {
                for(TeamStat teamStat : teamStats) {
                    if (teamStat.getTeam().equals(playerStats.get(i).getTeam())) {
                        if (playerStats.get(i).getInningsPitched() >= teamStat.getGames()) {
                            for(Team team : teams) {
                                if (team.getTeam().equals(teamStat.getTeam()) && team.getLeague().equals(getString(league))) {
                                    sortedPlayerStats.add(playerStats.get(i));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return sortedPlayerStats;
        }
        List<PlayerStat> sortedPlayerStats = new ArrayList<>();
        for(int i = 0; i < playerStats.size(); i++) {
            for(Team team : teams) {
                if (team.getTeam().equals(playerStats.get(i).getTeam()) && team.getLeague().equals(getString(league))) {
                    sortedPlayerStats.add(playerStats.get(i));
                    break;
                }
            }
        }
        return sortedPlayerStats;
    }
}
