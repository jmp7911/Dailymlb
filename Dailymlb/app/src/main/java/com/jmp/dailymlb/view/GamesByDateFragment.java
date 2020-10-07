package com.jmp.dailymlb.view;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.iface.OnClickResultListener;
import com.jmp.dailymlb.model.Constants;
import com.jmp.dailymlb.model.Game;
import com.jmp.dailymlb.model.Stadium;
import com.jmp.dailymlb.presenter.GamesContract;
import com.jmp.dailymlb.presenter.GamesPresenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.jmp.dailymlb.model.Constants.ONE_DAY_MILLS;

public class GamesByDateFragment extends Fragment implements GamesContract.View {
    View view;
    RecyclerView recyclerView;
    Context context;
    Button datePickerDialog;
    Button previous;
    Button following;
    Date today;
    SimpleDateFormat simpleDateFormat;
    private GamesPresenter gamesPresenter;
    private GamesAdapter gamesAdapter;
    private OnClickResultListener clickResultListener;
    public GamesByDateFragment(OnClickResultListener clickResultListener) {
        this.clickResultListener = clickResultListener;
    }

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
        today = new Date();
        simpleDateFormat = new SimpleDateFormat("d\nMMM", Locale.KOREA);
        datePickerDialog = view.findViewById(R.id.date_picker);
        datePickerDialog.setText(simpleDateFormat.format(today));
        datePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attachDatePickerDialog();
            }
        });
        previous = view.findViewById(R.id.date_prev);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBackPreviousDay();
            }
        });
        following = view.findViewById(R.id.date_follow);
        following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBackFollowingDay();
            }
        });
        gamesAdapter = new GamesAdapter(new OnClickResultListener() {
            @Override
            public void onClickResult(int gameId) {
                clickResultListener.onClickResult(gameId);
            }
        });
        recyclerView.setAdapter(gamesAdapter);




        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gamesPresenter = new GamesPresenter();
        gamesPresenter.attachView(this);
        if (gamesAdapter.getStadiums().isEmpty()) {
            gamesPresenter.getStadiums();
        }
        gamesPresenter.getGamesByDate(new Date());
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

    @Override
    public void setStadiums(List<Stadium> stadiums) {
        gamesAdapter.setStadiums(stadiums);
    }

    private void attachDatePickerDialog() {
        DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                gamesPresenter.getGamesByDate(year, monthOfYear, dayOfMonth);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                today.setTime(calendar.getTimeInMillis());
                datePickerDialog.setText(simpleDateFormat.format(today));
            }
        };
        Calendar calendar = Calendar.getInstance();
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(context, callBack, y, m, d);
        dialog.show();

    }

    private void callBackPreviousDay() {
        today.setTime(today.getTime() - ONE_DAY_MILLS);
        gamesPresenter.getGamesByDate(today);
        datePickerDialog.setText(simpleDateFormat.format(today));

    }

    private void callBackFollowingDay() {
        today.setTime(today.getTime() + ONE_DAY_MILLS);
        gamesPresenter.getGamesByDate(today);
        datePickerDialog.setText(simpleDateFormat.format(today));

    }
}
