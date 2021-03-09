package com.dglasmann.weatherapp.presentation.list

import com.dglasmann.weatherapp.data.CityRemoteDataSource
import com.dglasmann.weatherapp.data.CityRepositoryImpl
import com.dglasmann.weatherapp.data.RetrofitHolder
import com.dglasmann.weatherapp.domain.GetCitiesUseCase

object ListPresenterFactory {
    fun getPresenter(): ListPresenter {
        val cityDataSource = CityRemoteDataSource(RetrofitHolder.cityApi)
        val cityRepositoryImpl = CityRepositoryImpl(cityDataSource)
        val getCitiesUseCase = GetCitiesUseCase(cityRepositoryImpl)
        return ListPresenter(getCitiesUseCase)
    }
}