package com.jmp.dailymlb.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jmp.dailymlb.R;
import com.jmp.dailymlb.iface.OnClickResultListener;
import com.jmp.dailymlb.presenter.MainContract;
import com.jmp.dailymlb.presenter.MainPresenter;

import static com.jmp.dailymlb.model.Constants.GAME_ID;


public class MainActivity extends AppCompatActivity implements MainContract.View{
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.navi_view);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        final GamesByDateFragment dateFragment = new GamesByDateFragment(new OnClickResultListener() {
            @Override
            public void onClickResult(int gameId) {
                Intent intent = new Intent(getApplicationContext(), GameReviewActivity.class);
                intent.putExtra(GAME_ID, gameId);
                startActivity(intent);
            }
        });
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_layout, dateFragment).commit();
        final TeamRankFragment teamRankFragment = new TeamRankFragment();
        final PlayerRankFragment playerRankFragment = new PlayerRankFragment();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.team_rank) {
                    FragmentTransaction transaction1 = fragmentManager.beginTransaction();
                    transaction1.replace(R.id.fragment_layout, teamRankFragment).commit();
                    return true;
                } else if (menuItem.getItemId() == R.id.player_rank) {
                    FragmentTransaction transaction1 = fragmentManager.beginTransaction();
                    transaction1.replace(R.id.fragment_layout, playerRankFragment).commit();
                    return true;
                } else if (menuItem.getItemId() == R.id.daily_game) {
                    FragmentTransaction transaction1 = fragmentManager.beginTransaction();
                    transaction1.replace(R.id.fragment_layout, dateFragment).commit();
                    return true;
                }
                return false;
            }
        });
        presenter = new MainPresenter();
        presenter.attachView(this);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showToast(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }


}
