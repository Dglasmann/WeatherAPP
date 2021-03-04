package com.dglasmann.weatherapp.data

import com.dglasmann.weatherapp.domain.City

interface CityDataSource {

    fun getCity(id: Long): City?
    fun getCities(): List<City>
}
