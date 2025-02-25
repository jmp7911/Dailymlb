#!/bin/bash

sudo apt update
sudo apt-get upgrade

composer install --no-dev --optimize-autoloader

php artisan migrate --force

php artisan cache:clear
php artisan config:clear
php artisan route:clear
php artisan view:clear

