<?php

namespace App\Http\Controllers;

use App\Models\User;
use GuzzleHttp\Client;
use App\Models\weather;
use Illuminate\Http\Request;

class WeatherController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */

     function  WeatherExist($user_id,$city_id)
     {
         $list = Weather::where([
            ["user_id", $user_id],
            ["city_id", $city_id]
         ])->get();
         if (!empty($list[0])) {
             return true;
         } else {
             return false;
         }
         // dd($list);
         // return $list;
     }

    public function CityList()
    {
        $list = weather::all();
        return response()->json([
            'saved' => $list,
        ]);
    }
    public function getApi(){
        $client = new Client([
            'verify' => false,

        ]);

        $response = $client->request('GET', 'https://api.openweathermap.org/data/2.5/weather?q=tanger&appid=1253309e30b4fb953c136c1426565be0');
        $data = json_decode($response->getBody(), true);
        $weather = $data["weather"];
            $id =$data['id'];


        $humidity =  $data["main"]["humidity"];
        $temp =  $data["main"]["temp"];
        $feels_like =  $data["main"]["feels_like"];
        $city = $data["name"];
        $country=$data["sys"]["country"];

        $weather[0]+= array(

                "id" => $id,
                "humidity" => $humidity,
                "temp" => $temp,
                "feels_like" => $feels_like,
                "city" => $city,
                "country" => $country
            );


        return $weather[0] ;
    }

    // public function SaveCity(Request $request) {

    //     $city =  $request->city;

    //    $cityData= weather::where('name',$city)->get();
    //     // dd($cityData);

    //     if(!empty($cityData[0])){
    //         return response()->json([
    //             'status' => 'errur',
    //         ]);
    //     }
    //         else{


    //     $city_name = $request->input('city');
    //     $city = new weather();
    //     $city->name = $city_name;
    //     $city->save();

    //     $list = weather::all();

    //     return response()->json([
    //         'status' => 'success',
    //         'saved' => $list
    //     ]);
    // }

    // }

    public function checkCity(Request $request) {

        $city =  $request->city;

       $cityData= weather::where('name',$city)->get();
        // dd($cityData);

        if(!empty($cityData[0])){
            return response()->json([
                'status' => 'errur',
            ]);
        }
            else{
        return response()->json([
            'status' => 'success',

        ]);
    }

    }


    public function DeleteCity($id)
    {
        weather::where("id",$id)->delete();
        $list = weather::all();
        return response()->json([
            'saved' => $list,
        ]);

    }
    public function DeleteCityName($name)
    {
        weather::where("name",$name)->delete();
        $list = weather::all();
        return response()->json([
            'saved' => $list,
        ]);

    }




    //--------------------------------------
    function witherApi($name)
    {

        $client = new \GuzzleHttp\Client([
            'verify' => false,
            'headers' => [
                'x-rapidapi-host' => 'v3.football.api-sports.io',
                'x-rapidapi-key' => '8cc7b490ea845f35b524aef59d7e1782'
            ]
        ]);

        $response = $client->request('GET', 'https://api.openweathermap.org/data/2.5/weather?q=' . $name . '&appid=1253309e30b4fb953c136c1426565be0&units=metric&weather.icon');
        // &lang=an&timezone=Africa/Casablanca

        $data = json_decode($response->getBody(), true);

        $weather = $data["weather"];
        $id = $data['id'];



        $humidity =  $data["main"]["humidity"];
        $temp =  $data["main"]["temp"];
        $tempMax =  $data["main"]["temp_max"];
        $tempMin =  $data["main"]["temp_min"];
        $pressure =  $data["main"]["pressure"];
        $wind =  $data["wind"]["speed"];
        $sunrise =  $data["sys"]["sunrise"];
        $sunset =  $data["sys"]["sunset"];
        $feels_like =  $data["main"]["feels_like"];
        $city = $data["name"];
        $timeZone = $data["timezone"];
        $country = $data["sys"]["country"];

        $weather[0] += array(

            "id_city" => $id,
            "humidity" => $humidity,
            "temp" => $temp,
            "feels_like" => $feels_like,
            "city" => $city,
            "country" => $country,
            "temp_max"=>$tempMax,
            "temp_min"=>$tempMin,
            "pressure"=>$pressure,
            "speed"=>$wind,
            "sunrise"=>$sunrise,
            "sunset"=>$sunset,
            "timezone"=>$timeZone




        );


        return $weather[0];
    }

    function SaveCity(Request $request)
    {
        $weather = new Weather();

        $weather->name = $request->city;
        $weather->user_id = $request->user_id;
        $weather->city_id = $request->id;
        $weather->save();
        return true;
    }


    function SaveList($id){
        $weather = Weather::select("id","name as city")
        ->where('user_id',$id)
        ->get();
        return $weather;
   }
   function delete($id,$user_id){
    Weather::where([
        ["id", $id],
        ['user_id',$user_id]
    ])->delete();
        $listAll = Weather::all();
        return true;
   }
   function Login(Request $request)
   {


       $user = User::select("id", "password", "email")->where([
           ["email", $request->email],
           ["password", $request->password]
       ])->first();

       if ($user) {

           return $user;

       } else {
           return false;
       }
   }



}
