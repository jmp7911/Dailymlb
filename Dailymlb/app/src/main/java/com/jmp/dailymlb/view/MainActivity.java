package com.jmp.dailymlb.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.GsonBuilder;
import com.jmp.dailymlb.R;
import com.jmp.dailymlb.iface.APIService;
import com.jmp.dailymlb.presenter.MainContract;
import com.jmp.dailymlb.presenter.MainPresenter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private MainPresenter presenter;
    final String KEY = "4bebbc0605674b6c95b071224bca6339";
    final String BASE_URL = "https://api.sportsdata.io/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.navi_view);

        FragmentManager fragmentManager = getSupportFragmentManager();
        presenter = new MainPresenter();
        presenter.attachView(this);
        presenter.addFragment(fragmentManager);
        presenter.connectAPIService(BASE_URL);
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
