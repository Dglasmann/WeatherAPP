package com.dglasmann.weatherapp.presentation.details

import com.dglasmann.weatherapp.data.CityRemoteDataSource
import com.dglasmann.weatherapp.data.CityRepositoryImpl
import com.dglasmann.weatherapp.data.RetrofitHolder
import com.dglasmann.weatherapp.domain.GetCityUseCase

object DetailPresenterFactory {
    fun getPresenter(name: String): DetailsPresenter {
        val cityDataSource = CityRemoteDataSource(RetrofitHolder.cityApi)
        val cityRepositoryImpl = CityRepositoryImpl(cityDataSource)
        val getCityUseCase = GetCityUseCase(cityRepositoryImpl)
        return DetailsPresenter(getCityUseCase, name)
    }
}