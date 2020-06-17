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

import androidx.core.content.ContextCompat;

public class PlayerRankAdapter extends BaseAdapter {
    private List<String> playerStats;
    private LayoutInflater inflater;
    public PlayerRankAdapter(Context context) {
        this.playerStats = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return playerStats.size();
    }

    @Override
    public String getItem(int position) {
        return playerStats.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final PlayerRankViewHolder holder;
        String item = getItem(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_player_rank, null);
            holder = new PlayerRankViewHolder();
            holder.textView = convertView.findViewById(R.id.player_rank_text);
            convertView.setTag(holder);
        } else {
            holder = (PlayerRankViewHolder)convertView.getTag();
        }
        holder.textView.setText(item);
        return convertView;
    }

    public List<String> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(List<String> playerStats) {
        this.playerStats = playerStats;
    }

    class PlayerRankViewHolder {
        TextView textView;
    }
}






