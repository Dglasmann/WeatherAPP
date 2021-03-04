package com.dglasmann.weatherapp.presentation.list

import com.dglasmann.weatherapp.data.CityLocalDataSource
import com.dglasmann.weatherapp.data.CityRepositoryImpl
import com.dglasmann.weatherapp.domain.GetCitiesUseCase

object ListPresenterFactory {
    fun getPresenter(): ListPresenter {
        val cityDataSource = CityLocalDataSource()
        val cityRepositoryImpl = CityRepositoryImpl(cityDataSource)
        val getCitiesUseCase = GetCitiesUseCase(cityRepositoryImpl)
        return ListPresenter(getCitiesUseCase)
    }
}