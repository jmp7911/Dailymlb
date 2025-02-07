<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\TestController;
use App\Http\Middleware\AuthenticateOnceWithBasicAuth;

Route::get('/test', [TestController::class, 'index'])->middleware(AuthenticateOnceWithBasicAuth::class);;

Route::get('/hello', function () {
  return response()->json(['message' => 'Hello, Laravel 11 API!']);
});