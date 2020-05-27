package com.jmp.dailymlb.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.model.ScoreBoard;

import java.util.ArrayList;
import java.util.List;

import androidx.core.content.ContextCompat;


public class GameReviewInningAdapter extends BaseAdapter {
    private ArrayList<String> scoreBoards;
    private LayoutInflater layoutInflater;
    private Context context;
    public GameReviewInningAdapter(Context context) {
        this.scoreBoards = new ArrayList<>();
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return scoreBoards.size();
    }

    @Override
    public String getItem(int position) {
        return scoreBoards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        String item = getItem(position);
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_review, null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.review_item_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.textView.setText(item);
        int rowSize = scoreBoards.size() / 3;
        if (position / rowSize == 0) {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.color1));
        } else if (position / rowSize == 1) {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.color2));
        } else {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.color3));
        }
        return convertView;
    }

    class ViewHolder {
        TextView textView;
    }

    public void setScoreBoards(ArrayList<String> scoreBoards) {
        this.scoreBoards = scoreBoards;
    }
}
