package com.dglasmann.weatherapp.data

import com.dglasmann.weatherapp.domain.model.City
import com.dglasmann.weatherapp.domain.CityRepository
import com.dglasmann.weatherapp.domain.model.HTTPResponse
import io.reactivex.Single

class CityRepositoryImpl(private val cityDataSource: CityDataSource): CityRepository {
    override fun getCity(name: String): Single<City> = cityDataSource.getCity(name)
    override fun getCities(): Single<HTTPResponse> = cityDataSource.getCities()
}