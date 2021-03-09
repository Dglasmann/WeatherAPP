package com.dglasmann.weatherapp.data

import com.dglasmann.weatherapp.domain.model.City
import com.dglasmann.weatherapp.domain.model.HTTPResponse
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class CityRemoteDataSource(private val api: CityApi): CityDataSource{
    override fun getCity(name: String): Single<City> =
        api.getCity(name)
            .subscribeOn(Schedulers.io())

    override fun getCities(): Single<HTTPResponse> =
        api.getCitiesList()
            .subscribeOn(Schedulers.io())

}