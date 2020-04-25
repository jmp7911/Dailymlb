package com.jmp.dailymlb.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.model.Game;
import com.jmp.dailymlb.presenter.GamesContract;
import com.jmp.dailymlb.presenter.GamesPresenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GamesByDateFragment extends Fragment implements GamesContract.View {
    View view;
    RecyclerView recyclerView;
    Context context;
    private GamesPresenter gamesPresenter;
    private GamesAdapter gamesAdapter;


    @Override
    public void onAttach(Context cxt) {
        super.onAttach(cxt);
        context = cxt;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        gamesPresenter.detachView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_games_by_date, container, false);
        recyclerView = view.findViewById(R.id.scoreboard_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        gamesAdapter = new GamesAdapter();
        recyclerView.setAdapter(gamesAdapter);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gamesPresenter = new GamesPresenter();
        gamesPresenter.attachView(this);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);

        gamesPresenter.loadGamesByDate("2019-JUL-31");

    }

    @Override
    public void showToast(String title) {
        Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setGames(List<Game> games) {
        gamesAdapter.setGames(games);
        gamesAdapter.notifyDataSetChanged();
    }

}
