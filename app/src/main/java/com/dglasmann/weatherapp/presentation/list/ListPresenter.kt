package com.dglasmann.weatherapp.presentation.list

import com.dglasmann.weatherapp.domain.City
import com.dglasmann.weatherapp.domain.CityRepository
import com.dglasmann.weatherapp.domain.GetCitiesUseCase
import com.dglasmann.weatherapp.presentation.BasePresenter

class ListPresenter(private val getCitiesUseCase: GetCitiesUseCase): BasePresenter<ListView>() {

    fun onViewResumed() {
        val cityList = getCitiesUseCase()
        view?.bindCityList(cityList)
    }

    fun onCityClicked(city: City) {
        view?.openDetailsScreen(city.id)
    }

}