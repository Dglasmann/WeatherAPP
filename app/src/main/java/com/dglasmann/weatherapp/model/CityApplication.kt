package com.dglasmann.weatherapp

import android.app.Application

class CityApplication: Application() {
    val cityRepository = CityRepository()
}