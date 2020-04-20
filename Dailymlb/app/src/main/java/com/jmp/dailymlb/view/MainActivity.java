package com.jmp.dailymlb.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jmp.dailymlb.R;
import com.jmp.dailymlb.presenter.MainContract;
import com.jmp.dailymlb.presenter.MainPresenter;

import static com.jmp.dailymlb.model.Constants.KEY;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    private MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.navi_view);

        FragmentManager fragmentManager = getSupportFragmentManager();
        GamesByDateFragment dateFragment = new GamesByDateFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_layout, dateFragment).commit();

        presenter = new MainPresenter();
        presenter.attachView(this);
        presenter.getGamesByDate(KEY);




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
