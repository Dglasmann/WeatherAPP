package com.dglasmann.weatherapp.data

import com.dglasmann.weatherapp.domain.City
import com.dglasmann.weatherapp.domain.CityRepository

class CityRepositoryImpl(private val cityDataSource: CityDataSource): CityRepository {
    override fun getCity(id: Long): City? =
            cityDataSource.getCity(id)


    override fun getCities(): List<City> =
            cityDataSource.getCities()
}