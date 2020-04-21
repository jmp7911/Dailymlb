package com.jmp.dailymlb.presenter;

public interface GamesAdapterContract {
    interface View {
        void notifyItem();
    }
    interface Model {
        void addItem();
    }
}
