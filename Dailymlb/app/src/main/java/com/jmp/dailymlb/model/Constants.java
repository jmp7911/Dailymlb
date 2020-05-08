package com.jmp.dailymlb.model;

import com.jmp.dailymlb.R;

public class Constants {
    public static final String BASE_URL = "https://api.sportsdata.io/";
    public static final String KEY = "4bebbc0605674b6c95b071224bca6339";
    public enum Status {
        Scheduled("예정"),
        InProgress("진행"),
        Final("종료"),
        Suspended("중지"),
        Postponed("연기"),
        Canceled("취소");
        private final String status;
        Status(String status) {
            this.status = status;
        }
        public String getStatus() {
            return status;
        }
    }
    public enum Team {
        ARI(R.drawable.ari),
        ATL(R.drawable.atl),
        BAL(R.drawable.bal),
        BOS(R.drawable.bos),
        CHC(R.drawable.chc),
        CHW(R.drawable.chw),
        CIN(R.drawable.cin),
        CLE(R.drawable.cle),
        COL(R.drawable.col),
        DET(R.drawable.det),
        HOU(R.drawable.hou),
        KC(R.drawable.kc),
        LAA(R.drawable.laa),
        LAD(R.drawable.lad),
        MIA(R.drawable.mia),
        MIL(R.drawable.mil),
        MIN(R.drawable.min),
        NYM(R.drawable.nym),
        NYY(R.drawable.nyy),
        OAK(R.drawable.oak),
        PHI(R.drawable.phi),
        PIT(R.drawable.pit),
        SD(R.drawable.sd),
        SEA(R.drawable.sea),
        SF(R.drawable.sf),
        STL(R.drawable.stl),
        TB(R.drawable.tb),
        TEX(R.drawable.tex),
        TOR(R.drawable.tor),
        WSH(R.drawable.wsh);

        final private int drawableId;
        Team(int drawableId) {
            this.drawableId = drawableId;
        }
        public int getDrawableId() {
            return drawableId;
        }
    }
}
