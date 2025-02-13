<?php

namespace Tests\Unit;

use PHPUnit\Framework\TestCase;
use App\Http\Controllers\Api\SportsDataController;
class SportsDataControllerTest extends TestCase
{
    /**
     * A basic unit test example.
     */
    public function test_example(): void
    {
        $controller = new SportsDataController();
        $response = $controller->getStadiums();
        $this->assertTrue(true);
    }
}
