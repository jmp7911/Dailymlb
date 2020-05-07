package com.jmp.dailymlb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.model.Game;
import com.jmp.dailymlb.model.Stadium;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> {
    private List<Game> games;
    private List<Stadium> stadiums;
    public GamesAdapter() {
        this.games = new ArrayList<>();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtAwayTeam;
        ImageView imgAwayIcon;
        TextView txtAwayScore;
        TextView txtHomeTeam;
        ImageView imgHomeIcon;
        TextView txtHomeScore;
        TextView txtStadium;
        TextView txtDateTime;
        TextView txtStatus;
        Button btnResult;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAwayTeam = itemView.findViewById(R.id.text_away_team);
            imgAwayIcon = itemView.findViewById(R.id.away_icon);
            txtAwayScore = itemView.findViewById(R.id.text_away_score);
            txtHomeTeam = itemView.findViewById(R.id.text_home_team);
            imgHomeIcon = itemView.findViewById(R.id.home_icon);
            txtHomeScore = itemView.findViewById(R.id.text_home_score);
            txtStadium = itemView.findViewById(R.id.stadium);
            txtDateTime = itemView.findViewById(R.id.datetime);
            txtStatus = itemView.findViewById(R.id.text_status);
            btnResult = itemView.findViewById(R.id.btn_result);
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
        Game game = games.get(position);
        holder.txtDateTime.setText(formatDateTime(game.getDateTime()));
        holder.txtAwayTeam.setText(game.getAwayTeam());
        holder.txtHomeTeam.setText(game.getHomeTeam());
        holder.txtAwayScore.setText(String.valueOf(game.getAwayTeamRuns()));
        holder.txtHomeScore.setText(String.valueOf(game.getHomeTeamRuns()));
        holder.txtStatus.setText(translateStatus(game.getStatus()));
        for(Stadium stadium : stadiums) {
            if (games.get(position).getStadiumId() == stadium.getStadiumId()) {
                holder.txtStadium.setText(stadium.getName());
            }
        }
    }
    private String formatDateTime(String dateTime) {
        return dateTime.substring(11, 16);
    }
    private String translateStatus(String status) {
        String res = "";
        switch (status) {
            case "Scheduled" :
                res = "예정";
                break;
            case "InProgress" :
                res = "진행";
                break;
            case "Final" :
                res = "종료";
                break;
            case "Suspended" :
                res = "중지";
                break;
            case "PostPoned" :
                res = "연기";
                break;
            case "Canceled" :
                res = "취소";
                break;
        }
        return res;
    }
    @Override
    public int getItemCount() {
        return games.size();
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void setStadiums(List<Stadium> stadiums) {
        this.stadiums = stadiums;
    }
}
