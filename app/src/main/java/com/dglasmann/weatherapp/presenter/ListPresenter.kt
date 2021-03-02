package com.dglasmann.weatherapp

import com.dglasmann.weatherapp.model.City
import com.dglasmann.weatherapp.model.CityRepository

class ListPresenter(private val cityRepository: CityRepository): BasePresenter<ListView>() {

    fun onViewResumed() {
        val cityList = cityRepository.getCities()
        view?.bindCityList(cityList)
    }

    fun onCityClicked(city: City) {
        view?.openDetailsScreen(city.id)
    }

}