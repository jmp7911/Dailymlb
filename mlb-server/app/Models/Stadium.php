<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Stadium extends Model
{
    use HasFactory;
    protected $fillable = [
        'stadiumId', 'isActive', 'name', 'city', 'state', 'country'
    ];
}   
