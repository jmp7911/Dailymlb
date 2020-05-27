package com.jmp.dailymlb.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.iface.OnClickDetailStatListener;

import java.util.ArrayList;


public class GameReviewStatisticsAdapter extends BaseAdapter {
    ArrayList<String> stats;
    private LayoutInflater layoutInflater;
    Context context;
    public GameReviewStatisticsAdapter(Context context) {
        this.context = context;
        this.stats = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return stats.size();
    }

    @Override
    public String getItem(int position) {
        return stats.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        String item = getItem(position);
        int dp = (int)context.getResources().getDisplayMetrics().density;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_review, null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.review_item_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        convertView.setTag(R.string.statistics_detail, holder.textView.getText().toString());
        convertView.setBackgroundResource(R.drawable.border);
        holder.textView.setText(item);
        return convertView;
    }

    public ArrayList<String> getStats() {
        return stats;
    }

    public void setStats(ArrayList<String> stats) {
        this.stats = stats;
    }

    class ViewHolder {
        TextView textView;
    }
}
