package com.jmp.dailymlb.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jmp.dailymlb.R;
import com.jmp.dailymlb.iface.OnClickResultListener;
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
        GamesByDateFragment dateFragment = new GamesByDateFragment(new OnClickResultListener() {
            @Override
            public void onClickResult(int gameId) {
                GameReviewFragment gameReviewFragment = new GameReviewFragment(gameId);
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_layout, gameReviewFragment);
                transaction.addToBackStack(null).commit();
            }
        });
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_layout, dateFragment).commit();

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

    @Override
    public void setOnClickResultListener(OnClickResultListener clickResultListener) {

    }

}
