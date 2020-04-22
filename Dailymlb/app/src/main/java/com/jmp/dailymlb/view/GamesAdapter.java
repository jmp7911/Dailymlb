package com.jmp.dailymlb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.model.GameScore;
import com.jmp.dailymlb.presenter.GamesAdapterContract;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> implements GamesAdapterContract.Model, GamesAdapterContract.View {
    private List<GameScore> games;

    public GamesAdapter() {
        this.games = new ArrayList<>();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    @Override
    public void notifyItem() {
        notifyDataSetChanged();
    }

    @Override
    public void addItem(List<GameScore> games) {
        this.games = games;
    }
}
