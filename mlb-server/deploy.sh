#!/bin/bash

sudo apt update
sudo apt-get upgrade

composer install --no-dev --optimize-autoloader

php artisan migrate --force

