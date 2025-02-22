<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\TestController;
use App\Http\Controllers\Api\SportsDataController;

// 인증이 필요한 API (Sanctum 적용)
Route::middleware('auth:sanctum')->group(function () {
  Route::get('/test', [TestController::class, 'index']);

  Route::get('/Stadiums', [SportsDataController::class, 'getStadiums']);
  Route::get('/GamesByDate/{date}', [SportsDataController::class, 'getGamesByDate']);
  Route::get('/PlayerSeasonStatsSplitByTeam/{season}', [SportsDataController::class, 'getPlayerStats']);
  Route::get('/TeamSeasonStats/{season}', [SportsDataController::class, 'getTeamStats']);
  Route::get('/teams', [SportsDataController::class, 'getTeams']);
  Route::get('/PlayByPlay/{gameId}', [SportsDataController::class, 'getPlayByPlay']);
  Route::get('/PlayerGameStatsByPlayer/{date}/{playerId}', [SportsDataController::class, 'getPlayerGameStat']);
  Route::get('/Standings/{season}', [SportsDataController::class, 'getStandings']);
});

Route::get('/hello', function () {
  return response()->json(['message' => 'Hello, Laravel 11 API!']);
});
