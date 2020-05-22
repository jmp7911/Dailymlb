package com.jmp.dailymlb.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.model.Inning;
import com.jmp.dailymlb.model.Play;
import com.jmp.dailymlb.model.PlayByPlay;
import com.jmp.dailymlb.model.PlayerStat;

import java.util.ArrayList;
import java.util.List;


public class GameReviewInningAdapter extends BaseAdapter {
    private List<Inning> innings;
    private LayoutInflater layoutInflater;
    private Context context;

    public GameReviewInningAdapter(Context context) {
        this.context = context;
        this.innings = new ArrayList<>();
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return innings.size() * 3;
    }

    @Override
    public Inning getItem(int position) {
        return innings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final Inning inning = getItem(position);
        int size = innings.size();
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_inning, null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.item_inning_view_inning);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        if (inning != null) {
            if (position % size == 0) {
                if (position / size == 1) {
                    holder.textView.setText(inning.getAwayTeam());
                } else if (position / size == 2) {
                    holder.textView.setText(inning.getHomeTeam());
                }
            }
        }
        return convertView;
    }

    class ViewHolder {
        TextView textView;
    }

    public void setInnings(List<Inning> innings) {
        this.innings = innings;
    }
}
