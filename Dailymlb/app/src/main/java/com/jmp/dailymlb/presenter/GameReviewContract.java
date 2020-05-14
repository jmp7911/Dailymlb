package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.model.GameReviewWrapper;
import com.jmp.dailymlb.model.Play;
import com.jmp.dailymlb.model.PlayByPlay;

import java.util.List;

public interface GameReviewContract {
    interface View {
        void showToast(String title);
        void setPlayByPlay(PlayByPlay playByPlay);
    }
    interface Presenter {
        void attachView(View view);
        void detachView();
        void getPlayByPlay(int gameId);
    }
}
