package com.jmp.dailymlb.iface;



import com.google.gson.annotations.SerializedName;
import com.jmp.dailymlb.model.Play;
import com.jmp.dailymlb.model.PlayByPlay;
import com.jmp.dailymlb.model.PlayerStat;
import com.jmp.dailymlb.model.Stadium;
import com.jmp.dailymlb.model.Game;
import com.jmp.dailymlb.model.Standing;
import com.jmp.dailymlb.model.Team;
import com.jmp.dailymlb.model.TeamStat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("/v3/mlb/scores/json/GamesByDate/{date}")
    Call<List<Game>> getGamesByDate(@Path("date") String date, @Query("key") String key);
    @GET("/v3/mlb/scores/json/Stadiums")
    Call<List<Stadium>> getStadiums(@Query("key") String key);
    @GET("/v3/mlb/stats/json/PlayerSeasonStatsSplitByTeam/{season}")
    Call<List<PlayerStat>> getPlayerStats(@Path("season") int season, @Query("key") String key);
    @GET("/v3/mlb/scores/json/TeamSeasonStats/{season}")
    Call<List<TeamStat>> getTeamStats(@Path("season") int season, @Query("key") String key);
    @GET("/v3/mlb/scores/json/teams")
    Call<List<Team>> getTeams(@Query("key") String key);
    @GET("/v3/mlb/pbp/json/PlayByPlay/{GameID}")
    Call<PlayByPlay> getPlayByPlay(@Path("GameID") int gameId, @Query("key") String key);
    @GET("/v3/mlb/stats/json/PlayerGameStatsByPlayer/{date}/{playerId}")
    Call<List<PlayerStat>> getPlayerGameStat(@Path("date") String date, @Path("playerId") int playerId, @Query("key") String key);
    @GET("v3/mlb/scores/json/Standings/{season}")
    Call<List<Standing>> getStandings(@Path("season") int season, @Query("key") String key);
}
