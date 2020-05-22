package com.jmp.dailymlb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.jmp.dailymlb.R;
import com.jmp.dailymlb.model.Game;
import com.jmp.dailymlb.model.Inning;
import com.jmp.dailymlb.model.Play;
import com.jmp.dailymlb.model.PlayByPlay;
import com.jmp.dailymlb.presenter.GameReviewContract;
import com.jmp.dailymlb.presenter.GameReviewPresenter;

import java.util.List;

import static com.jmp.dailymlb.model.Constants.GAME_ID;

public class GameReviewActivity extends AppCompatActivity implements GameReviewContract.View {
    PlayByPlay playByPlay;
    int gameId;
    GameReviewPresenter gameReviewPresenter;
    GridView inningBoard;
    GameReviewInningAdapter gameReviewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_review);
        Intent intent = getIntent();
        gameId = intent.getIntExtra(GAME_ID, 0);
        gameReviewPresenter = new GameReviewPresenter();
        gameReviewPresenter.attachView(this);
        gameReviewPresenter.getPlayByPlay(gameId);
        inningBoard = findViewById(R.id.review_inning_board_grid_view);
        gameReviewAdapter = new GameReviewInningAdapter(this);

        inningBoard.setAdapter(gameReviewAdapter);

    }

    @Override
    public void showToast(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPlayByPlay(PlayByPlay playByPlay) {
        this.playByPlay = playByPlay;

        Game game = playByPlay.getGame();
        List<Inning> innings = game.getInnings();
        Inning inning = new Inning();
        inning.setAwayTeam(game.getAwayTeam());
        inning.setHomeTeam(game.getHomeTeam());
        innings.add(0, inning);
        inningBoard.setNumColumns(innings.size());
        gameReviewAdapter.setInnings(game.getInnings());
    }
    private String countBases(int teamId) {
        int count = 0;
        for (Play play : playByPlay.getPlays()) {
            if (play.getHitterTeamId() == teamId) {
                if (play.isWalk() ||
                        play.getResult().equals(getResources().getString(R.string.play_result_hit_by_pitch))) {
                    count++;
                }

            }
        }
        return String.valueOf(count);
    }
}
