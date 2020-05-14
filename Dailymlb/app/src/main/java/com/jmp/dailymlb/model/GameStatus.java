package com.jmp.dailymlb.model;

public enum GameStatus {
    Scheduled("예정"),
    InProgress("진행"),
    Final("종료"),
    Suspended("중지"),
    Postponed("연기"),
    Canceled("취소");
    private final String status;
    GameStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}