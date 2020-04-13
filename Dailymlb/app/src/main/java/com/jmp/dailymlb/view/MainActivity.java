package com.jmp.dailymlb.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.GsonBuilder;
import com.jmp.dailymlb.R;
import com.jmp.dailymlb.iface.APIService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.navi_view);

        FragmentManager fragmentManager = getSupportFragmentManager();
        GamesByDateFragment dateFragment = new GamesByDateFragment();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        transaction.add(R.id.fragment, dateFragment).commit();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.sportsdata.io/v3/mlb/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DAY_OF_MONTH, 31);



    }
}
