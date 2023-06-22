<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\WeatherController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});


Route::any('/list',[WeatherController::class,'CityList']);
// Route::post('/save',[WeatherController::class,'SaveCity']);
Route::post('/checkCity',[WeatherController::class,'checkCity']);
Route::post('/delete/{id}',[WeatherController::class,'DeleteCity']);
Route::post('/DeleteCityName/{name}',[WeatherController::class,'DeleteCityName']);
Route::get('/getApi',[WeatherController::class,'getApi']);

//-----------
Route::get('witherApi/{name}',[WeatherController::class,'witherApi']);

Route::post('SaveCity',[WeatherController::class,'SaveCity']);

Route::get('SaveList/{user_id}',[WeatherController::class,'SaveList']);
Route::delete('delete/{id}/{user_id}',[WeatherController::class,'delete']);
Route::post('Login',[WeatherController::class,'Login']);
Route::get('WeatherExist/{user_id}/{city_id}',[WeatherController::class,'WeatherExist']);
