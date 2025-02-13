<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use GuzzleHttp\Client;

class SportsDataController extends Controller
{
    private $client=null;
    public function __construct() {
        if ($this->client == null) {
            $this->client = new Client([
                'base_uri' => 'http://api.sportsdata.io',
                'timeout'  => 2.0
            ]);
        }
    }
    
    public function getStadiums() {
        try {
            $response = $this->client->get('/v3/mlb/scores/json/Stadiums', [
                'query' => [
                    'key' => '4bebbc0605674b6c95b071224bca6339'
                ]
            ]);
        } catch (\Exception $e) {
            // dd($e->getMessage());
        }
        if ($response->getStatusCode() == 200) {
            $stadiums = $response->getBody()->getContents();
        }
        
        return $stadiums;
    }
}
