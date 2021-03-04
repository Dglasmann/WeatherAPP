package com.dglasmann.weatherapp.presentation.details

import com.dglasmann.weatherapp.data.CityLocalDataSource
import com.dglasmann.weatherapp.data.CityRepositoryImpl
import com.dglasmann.weatherapp.domain.GetCityUseCase

object DetailsPresenterFactory {
    fun getPresenter(id: Long): DetailPresenter {
        val cityDataSource = CityLocalDataSource()
        val cityRepositoryImpl = CityRepositoryImpl(cityDataSource)
        val getCityUseCase = GetCityUseCase(cityRepositoryImpl)
        return DetailPresenter(getCityUseCase, id)
    }
}