package com.jmp.dailymlb.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmp.dailymlb.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GamesByDateFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    Context context;
    @Override
    public void onAttach(Context cxt) {
        super.onAttach(cxt);
        context = cxt;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_games_by_date, container, false);
        recyclerView = view.findViewById(R.id.scoreboard_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        GamesAdapter adapter = new GamesAdapter();
        recyclerView.setAdapter(adapter);
        return view;

    }

}
