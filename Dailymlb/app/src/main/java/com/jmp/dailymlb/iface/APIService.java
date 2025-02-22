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
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("GamesByDate/{date}")
    Call<List<Game>> getGamesByDate(@Path("date") String date, @Header("Authorization") String apiKey);
    @GET("Stadiums")
    Call<List<Stadium>> getStadiums(@Header("Authorization") String apiKey);
    @GET("PlayerSeasonStatsSplitByTeam/{season}")
    Call<List<PlayerStat>> getPlayerStats(@Path("season") int season, @Header("Authorization") String apiKey);
    @GET("TeamSeasonStats/{season}")
    Call<List<TeamStat>> getTeamStats(@Path("season") int season, @Header("Authorization") String apiKey);
    @GET("teams")
    Call<List<Team>> getTeams(@Header("Authorization") String apiKey);
    @GET("PlayByPlay/{GameID}")
    Call<PlayByPlay> getPlayByPlay(@Path("GameID") int gameId, @Header("Authorization") String apiKey);
    @GET("PlayerGameStatsByPlayer/{date}/{playerId}")
    Call<List<PlayerStat>> getPlayerGameStat(@Path("date") String date, @Path("playerId") int playerId, @Header("Authorization") String apiKey);
    @GET("Standings/{season}")
    Call<List<Standing>> getStandings(@Path("season") int season, @Header("Authorization") String apiKey);
}
