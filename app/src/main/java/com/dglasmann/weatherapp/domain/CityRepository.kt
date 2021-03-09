package com.dglasmann.weatherapp.domain

import com.dglasmann.weatherapp.domain.model.City
import com.dglasmann.weatherapp.domain.model.HTTPResponse
import io.reactivex.Completable
import io.reactivex.Single

interface CityRepository{

    fun getCity(name: String): Single<City>
    fun getCities(): Single<HTTPResponse>
}