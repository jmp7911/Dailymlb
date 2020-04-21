package com.jmp.dailymlb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.iface.OnItemClickListener;
import com.jmp.dailymlb.model.Score;
import com.jmp.dailymlb.presenter.GamesAdapterContract;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> implements GamesAdapterContract.View, GamesAdapterContract.Model {
    private List<Score> games;
    private OnItemClickListener onItemClickListener;
    public GamesAdapter() {
        this.games = new ArrayList<>();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.btn_result);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_games, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder view, final int position) {
        view.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return games.size();
    }


    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItem() {
        Score score = new Score();
        games.add(score);
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
