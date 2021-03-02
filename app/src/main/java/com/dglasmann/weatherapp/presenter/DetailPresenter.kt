package com.dglasmann.weatherapp

import com.dglasmann.weatherapp.model.CityRepository


class DetailPresenter(
        private val cityRepository: CityRepository,
        private val cityId: Long
): BasePresenter<DetailView>() {

    override fun onViewAttached() {
        val city = cityRepository.getCity(cityId)
        if (city != null) {
            view?.bindCity(city)
        } else {
            view?.closeScreen()
        }
    }

    fun getBack() {
        view?.closeScreen()
    }
}