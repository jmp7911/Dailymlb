package com.jmp.dailymlb.presenter;

import android.view.SurfaceControl;
import android.view.View;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.iface.APIService;
import com.jmp.dailymlb.model.Score;
import com.jmp.dailymlb.view.GamesByDateFragment;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private Retrofit retrofit;
    private APIService apiService;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void addFragment(FragmentManager fragmentManager) {
        GamesByDateFragment dateFragment = new GamesByDateFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_layout, dateFragment).commit();
    }

    @Override
    public void connectAPIService(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);
    }

    @Override
    public String getGamesByDate(String key) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        //Date date = new Date();
        //테스트용 날짜 2019-JUL-31
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DAY_OF_MONTH, 31);

        Call<ResponseBody> gamesByDate = apiService.gamesByDate(sdf.format(calendar.getTime()), key);
        gamesByDate.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println(response.raw());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
        return null;
    }
}
