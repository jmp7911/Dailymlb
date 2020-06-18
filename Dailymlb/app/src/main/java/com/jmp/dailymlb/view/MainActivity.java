package com.jmp.dailymlb.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jmp.dailymlb.R;
import com.jmp.dailymlb.presenter.MainContract;
import com.jmp.dailymlb.presenter.MainPresenter;


public class MainActivity extends AppCompatActivity implements MainContract.View{
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.navi_view);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        GamesByDateFragment dateFragment = new GamesByDateFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_layout, dateFragment).commit();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.player_rank) {
                    FragmentTransaction transaction1 = fragmentManager.beginTransaction();
                    PlayerRankFragment playerRankFragment = new PlayerRankFragment();
                    transaction1.replace(R.id.fragment_layout, playerRankFragment).commit();
                    return true;
                } else if (menuItem.getItemId() == R.id.daily_game) {
                    FragmentTransaction transaction1 = fragmentManager.beginTransaction();
                    GamesByDateFragment gamesByDateFragment = new GamesByDateFragment();
                    transaction1.replace(R.id.fragment_layout, gamesByDateFragment).commit();
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
