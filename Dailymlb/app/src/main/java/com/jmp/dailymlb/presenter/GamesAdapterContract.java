package com.jmp.dailymlb.presenter;

import com.jmp.dailymlb.iface.OnItemClickListener;

public interface GamesAdapterContract {
    interface View {
        void notifyItem();
    }
    interface Model {
        void addItem();
        void setOnItemClickListener(OnItemClickListener onItemClickListener);
    }
}