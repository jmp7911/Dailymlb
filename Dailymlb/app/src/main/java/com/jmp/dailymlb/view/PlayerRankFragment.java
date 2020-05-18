package com.jmp.dailymlb.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
        playerRankPresenter = new PlayerRankPresenter();
        playerRankPresenter.attachView(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        playerRankPresenter.getPlayerStats(new Date());
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
        onBindBatterRankView(tableAverage, getTOP5PlayerStats(R.string.batting_average), R.string.batting_average);
    }

    private void onBindBatterRankView(TableLayout tableLayout, List<PlayerStat> TOP5PlayerStats, int resId) {
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
                        return 1;
                    } else if (playerStat.getAvg() == t1.getAvg()) {
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
