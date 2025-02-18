<?php

use App\Http\Controllers\ProfileController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TestController;
use Illuminate\Http\Request;
 
Route::get('/tokens/create', function (Request $request) {
    $token = $request->user()->createToken('api');
 
    return ['token' => $token->plainTextToken];
})->middleware('auth:sanctum');

Route::get('/', function () {
    return response()->json(['message' => 'Hello, Laravel 11 API!']);
});

Route::get('/dashboard', function () {
    return view('dashboard');
})->middleware(['auth', 'verified'])->name('dashboard');

Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');
});

require __DIR__.'/auth.php';

// Route::get('/test', [TestController::class, 'index']);
