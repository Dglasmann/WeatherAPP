package com.dglasmann.weatherapp.model

import android.app.Application

class CityApplication: Application() {
    val cityRepository = CityRepository()
}