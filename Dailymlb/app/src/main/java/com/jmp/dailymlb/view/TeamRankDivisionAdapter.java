package com.jmp.dailymlb.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jmp.dailymlb.R;

import java.util.ArrayList;
import java.util.List;

public class TeamRankDivisionAdapter extends BaseAdapter {
    List<String> teamStats;
    LayoutInflater inflater;
    public TeamRankDivisionAdapter(Context context) {
        this.teamStats = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return teamStats.size();
    }

    @Override
    public String getItem(int position) {
        return teamStats.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String item = getItem(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_team_rank, null);
        }
        convertView.setBackgroundResource(R.drawable.border);
        TextView textView = convertView.findViewById(R.id.team_rank_item_text);
        textView.setText(item);
        return convertView;
    }

    public void setTeamStats(List<String> teamStats) {
        this.teamStats = teamStats;
    }
}
