<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\TestController;
use App\Http\Controllers\Api\SportsDataController;

// 인증이 필요한 API (Sanctum 적용)
Route::middleware('auth:sanctum')->group(function () {
  Route::get('/test', [TestController::class, 'index']);
});

Route::get('/hello', function () {
  return response()->json(['message' => 'Hello, Laravel 11 API!']);
});

Route::get('/stadium', [SportsDataController::class, 'getStadiums']);