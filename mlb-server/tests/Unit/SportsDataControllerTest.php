<?php

namespace Tests\Unit;

use Tests\TestCase;
use App\Http\Controllers\Api\SportsDataController;
use Illuminate\Support\Facades\Http;
use Illuminate\Support\Facades\Cache;
class SportsDataControllerTest extends TestCase
{
    /**
     * A basic unit test example.
     */
    public function test_get_stadium(): void
    {
        Http::fake([
            'api.example.com/api/stadium' => Http::response([[]], 200),
        ]);

        $response = Http::get('https://api.example.com/api/stadium');
        $this->assertEquals(200, $response->status());
    }
}
