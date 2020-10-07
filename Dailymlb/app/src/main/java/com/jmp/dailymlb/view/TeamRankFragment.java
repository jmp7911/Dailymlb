package com.jmp.dailymlb.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.model.Standing;
import com.jmp.dailymlb.model.Team;
import com.jmp.dailymlb.model.TeamStat;
import com.jmp.dailymlb.model.Teams;
import com.jmp.dailymlb.presenter.TeamRankContract;
import com.jmp.dailymlb.presenter.TeamRankPresenter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TeamRankFragment extends Fragment implements TeamRankContract.View {
    View view;
    List<TeamStat> teamStats;
    List<Standing> standings;
    List<Team> teams;
    TeamRankPresenter teamRankPresenter;
    Button btnALTeamRank;
    Button btnNLTeamRank;
    GridView westDivision;
    GridView centralDivision;
    GridView eastDivision;
    GridView wildCard;
    TextView westDivisionText;
    TextView centralDivisionText;
    TextView eastDivisionText;
    TextView wildCardText;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (teamRankPresenter != null) {
            teamRankPresenter.detachView();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_team_season_rank, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        westDivision = view.findViewById(R.id.team_rank_west_division_container);
        centralDivision = view.findViewById(R.id.team_rank_central_division_container);
        eastDivision = view.findViewById(R.id.team_rank_east_division_container);
        wildCard = view.findViewById(R.id.team_rank_wild_card_container);
        westDivisionText = view.findViewById(R.id.team_rank_west_division_text);
        centralDivisionText = view.findViewById(R.id.team_rank_central_division_text);
        eastDivisionText = view.findViewById(R.id.team_rank_east_division_text);
        wildCardText = view.findViewById(R.id.team_rank_wild_card_text);
        btnALTeamRank = view.findViewById(R.id.team_rank_american_league_button);
        btnNLTeamRank = view.findViewById(R.id.team_rank_national_league_button);
        teamRankPresenter = new TeamRankPresenter();
        teamRankPresenter.attachView(this);
        //teamRankPresenter.getTeams();
        //teamRankPresenter.getTeamStats(new Date());
        teamRankPresenter.getStandings(new Date());
        /*
        btnALTeamRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (teamStats != null && teams != null) {
                    showTeamRank(R.string.american_league);
                }
            }
        });
        btnNLTeamRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (teamStats != null && teams != null) {
                    showTeamRank(R.string.national_league);
                }
            }
        });

         */
        btnALTeamRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (standings != null) {
                    showTeamRank(R.string.american_league);
                }
            }
        });
        btnNLTeamRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (standings != null) {
                    showTeamRank(R.string.national_league);
                }
            }
        });
    }

    @Override
    public void showToast(String title) {
        Toast.makeText(getContext(), title, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setTeamStats(List<TeamStat> teamStats) {
        this.teamStats = teamStats;
        showTeamRank(R.string.american_league);
    }

    @Override
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public void setStandings(List<Standing> standings) {
        this.standings = standings;
    }

    private void showTeamRank(int league) {
        if (standings == null) {
            Toast.makeText(getContext(), "정보를 불러오고 있습니다. 조금만 기다려주세요", Toast.LENGTH_SHORT).show();
            return;
        } else if (standings.size() == 0) {
            Toast.makeText(getContext(), "정보를 불러오고 있습니다. 조금만 기다려주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        setTeamRankAdapter(westDivision, league, R.string.west_division);
        setTeamRankAdapter(centralDivision, league, R.string.central_division);
        setTeamRankAdapter(eastDivision, league, R.string.east_division);
        setTeamRankAdapter(wildCard, league, R.string.wild_card);
    }

    private void setTeamRankAdapter(GridView container, int league, int division) {
        List<String> teamRanks = new ArrayList<>();
        teamRanks.add("순위");
        teamRanks.add("팀");
        teamRanks.add("경기");
        teamRanks.add("승");
        teamRanks.add("패");
        teamRanks.add("승률");
        teamRanks.add("게임차");
        /*
        List<TeamStat> sortedTeamStats = getSortedTeamStats(league, division);
        int[] rank = getRank(sortedTeamStats);
        float[] difference = getDifferenceOfGames(sortedTeamStats);
        for(int i = 0; i < sortedTeamStats.size(); i++) {
            TeamStat teamStat = sortedTeamStats.get(i);
            teamRanks.add(String.valueOf(rank[i]));
            for(Team team : teams) {
                if (team.getTeam().equals(teamStat.getTeam())) {
                    teamRanks.add(team.getTeam());
                    break;
                }
            }
            teamRanks.add((teamStat.getGames() + "G"));
            teamRanks.add(teamStat.getWins() + "승");
            teamRanks.add(teamStat.getLosses() + "패");
            teamRanks.add(String.format("%.3f", teamStat.getWins() / teamStat.getGames()));
            teamRanks.add(String.format("%.1f", difference[i]));
        }
         */
        List<Standing> sortedStandings = getSortedStandings(league, division);
        int[] rank = getRank(sortedStandings, division == R.string.wild_card);
        for(int i = 0; i < rank.length; i++) {
            Standing standing = sortedStandings.get(i);
            teamRanks.add(String.valueOf(rank[i]));
            teamRanks.add(standing.getKey());
            teamRanks.add(standing.getWins() + standing.getLosses() + "G");
            teamRanks.add(standing.getWins() + "승");
            teamRanks.add(standing.getLosses() + "패");
            teamRanks.add(String.format("%.3f", standing.getPercentage()));
            if (division == R.string.wild_card) {
                teamRanks.add(String.format("%.1f", standing.getWildCardGamesBehind()));

            } else {
                teamRanks.add(String.format("%.1f", standing.getGamesBehind()));

            }
        }
        if (teamRanks.size() >= 43) {
            teamRanks = teamRanks.subList(0, 42);
        }
        for(int i = 0; i < 7; i++) {
            teamRanks.add("");
        }
        TeamRankDivisionAdapter teamRankDivisionAdapter = new TeamRankDivisionAdapter(getContext());
        teamRankDivisionAdapter.setTeamStats(teamRanks);
        container.setAdapter(teamRankDivisionAdapter);
    }
    private List<Standing> getSortedStandings(int league, final int division) {
        List<Standing> sortedStandings = new ArrayList<>();
        for(Standing standing : standings) {
            if (standing.getLeague().equals(getString(league))) {
                if (division == R.string.wild_card) {
                    sortedStandings.add(standing);
                } else {
                    if (standing.getDivision().equals(getString(division))) {
                        sortedStandings.add(standing);
                    }
                }

            }
        }
        sortedStandings.sort(new Comparator<Standing>() {
            @Override
            public int compare(Standing standing, Standing t1) {
                if (standing.getPercentage() > t1.getPercentage()) {
                    return -1;
                } else if (standing.getPercentage() == t1.getPercentage()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        return sortedStandings;
    }
    /*
    private List<TeamStat> getSortedTeamStats(int league, int division) {
        List<TeamStat> sortedTeamStats = new ArrayList<>();
        teamStats.sort(new Comparator<TeamStat>() {
            @Override
            public int compare(TeamStat teamStat, TeamStat t1) {
                if (teamStat.getWins() / teamStat.getGames() < t1.getWins() / t1.getGames()) {
                    return 1;
                } else if (teamStat.getWins() / teamStat.getGames() == t1.getWins() / t1.getGames()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        if (division == R.string.wild_card) {
            boolean westDivision = false;
            boolean centralDivision = false;
            boolean eastDivision = false;
            for(int i = 0; i < teamStats.size(); i++) {
                if (sortedTeamStats.size() == 5) {
                    break;
                }
                for(Team team : teams) {
                    if (team.getTeam().equals(teamStats.get(i).getTeam())) {
                        if (team.getLeague().equals(getString(league))) {
                            if (team.getDivision().equals(getString(R.string.west_division))) {
                                if (westDivision) {
                                    sortedTeamStats.add(teamStats.get(i));
                                }
                                if (!westDivision && team.getDivision().equals(getString(R.string.west_division))) {
                                    westDivision = true;
                                    break;
                                }
                            } else if (team.getDivision().equals(getString(R.string.central_division))) {
                                if (centralDivision) {
                                    sortedTeamStats.add(teamStats.get(i));
                                }
                                if (!centralDivision && team.getDivision().equals(getString(R.string.central_division))) {
                                    centralDivision = true;
                                    break;
                                }
                            } else if (team.getDivision().equals(getString(R.string.east_division))) {
                                if (eastDivision) {
                                    sortedTeamStats.add(teamStats.get(i));
                                }
                                if (!eastDivision && team.getDivision().equals(getString(R.string.east_division))) {
                                    eastDivision = true;
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }
            return sortedTeamStats;
        } else {
            for(int i = 0; i < teamStats.size(); i++) {
                for(Team team : teams) {
                    if (team.getTeam().equals(teamStats.get(i).getTeam())) {
                        if (team.getLeague().equals(getString(league)) && team.getDivision().equals(getString(division))) {
                            sortedTeamStats.add(teamStats.get(i));
                            break;
                        }
                    }
                }
            }
            return sortedTeamStats;
        }
    }

     */
    /*
    private int[] getRank(List<TeamStat> sortedTeamStats) {
        int[] rank = new int[sortedTeamStats.size()];
        for(int i = 0; i < rank.length; i++) {
            rank[i] = 1;
            for(int j = 0; j < rank.length; j++) {
                if (sortedTeamStats.get(i).getWins() / sortedTeamStats.get(i).getGames() <
                sortedTeamStats.get(j).getWins() / sortedTeamStats.get(j).getGames()) {
                    rank[i]++;
                }
            }
        }
        return rank;
    }

     */
    private int[] getRank(List<Standing> sortedStandings, boolean isWildCard) {
        if (isWildCard) {
            for(Iterator<Standing> it = sortedStandings.iterator(); it.hasNext();) {
                if (it.next().getGamesBehind() == 0.0) {
                    it.remove();
                }
            }
        }
        int len = Math.min(sortedStandings.size(), 10);
        int[] rank = new int[len];
        for(int i = 0; i < len; i++) {
            rank[i] = 1;
            for(int j = 0; j < rank.length; j++) {
                if (sortedStandings.get(i).getPercentage() < sortedStandings.get(j).getPercentage())
                        rank[i]++;
                    }
            }
        return rank;
    }
    /*
    private float[] getDifferenceOfGames(List<TeamStat> sortedTeamStats) {
        float[] difference = new float[sortedTeamStats.size()];
        TeamStat firstTeam = sortedTeamStats.get(0);
        for(int i = 0; i < sortedTeamStats.size(); i++) {
            difference[i] = 0;
            if (i == 0) {
                continue;
            }
            difference[i] = (firstTeam.getWins() - sortedTeamStats.get(i).getWins()) -
                    (firstTeam.getLosses() - sortedTeamStats.get(i).getLosses());
            difference[i] /= 2.0;
        }
        return difference;
    }

     */
}
