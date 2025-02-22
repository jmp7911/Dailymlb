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
        $response = $this->client->get('/v3/mlb/scores/json/Stadiums', [
            'query' => [
                'key' => env('SPORTS_DATA_API_KEY')
            ]
        ]);
        
        if ($response->getStatusCode() == 200) {
            $JsonBody = $response->getBody()->getContents();
        }
        
        return $JsonBody;
    }

    public function getGamesByDate($date) {
        $response = $this->client->get("/v3/mlb/scores/json/GamesByDate/{$date}", [
            'query' => [
                'key' => env('SPORTS_DATA_API_KEY')
            ]
        ]);
        
        if ($response->getStatusCode() == 200) {
            $JsonBody = $response->getBody()->getContents();
        }
        
        return $JsonBody;
    }

    public function getPlayerStats($season) {
        $response = $this->client->get("/v3/mlb/stats/json/PlayerSeasonStatsSplitByTeam/{$season}", [
            'query' => [
                'key' => env('SPORTS_DATA_API_KEY')
            ]
        ]);
        if ($response->getStatusCode() == 200) {
            $JsonBody = $response->getBody()->getContents();
        }
        return $JsonBody;
    }

    public function getTeamStats($season) {
        $response = $this->client->get("/v3/mlb/scores/json/TeamSeasonStats/{$season}", [
            'query' => [
                'key' => env('SPORTS_DATA_API_KEY')
            ]
        ]);
        if ($response->getStatusCode() == 200) {
            $JsonBody = $response->getBody()->getContents();
        }
        return $JsonBody;
    }

    public function getTeams() {
        $response = $this->client->get('v3/mlb/scores/json/teams', [
            'query'=> [
                'key'=> env('SPORTS_DATA_API_KEY')
            ]
        ]);
        if ($response->getStatusCode() == 200) {
            $JsonBody = $response->getBody()->getContents();
        }
        return $JsonBody;

    }

    public function getPlayByPlay($gameId) {
        $response = $this->client->get("/v3/mlb/pbp/json/PlayByPlay/{$gameId}", [
            "query"=> [
                "key"=> env('SPORTS_DATA_API_KEY')
            ]
        ]);
        if ($response->getStatusCode() == 200) {
            $JsonBody = $response->getBody()->getContents();
        }
        return $JsonBody;

    }

    public function getPlayerGameStat($date, $playerId) {
        $response = $this->client->get("/v3/mlb/stats/json/PlayerGameStatsByPlayer/{$date}/{$playerId}", [
            "query"=> [
                "key"=> env('SPORTS_DATA_API_KEY')
            ]
        ]);
        if ($response->getStatusCode() == 200) {
            $JsonBody = $response->getBody()->getContents();
        }
        return $JsonBody;
    }

    public function getStandings($season) {
        $response = $this->client->get("/v3/mlb/scores/json/Standings/{$season}", [
            "query"=> [
                "key"=> env('SPORTS_DATA_API_KEY')
            ]
        ]);
        if ($response->getStatusCode() == 200) {
            $JsonBody = $response->getBody()->getContents();
        }
        return $JsonBody;
    }
}
