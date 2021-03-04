package com.dglasmann.weatherapp.presentation.details

import com.dglasmann.weatherapp.domain.GetCityUseCase
import com.dglasmann.weatherapp.presentation.BasePresenter

class DetailPresenter(
        private val getCityUseCase: GetCityUseCase,
        private val cityId: Long
): BasePresenter<DetailView>() {

    override fun onViewAttached() {
        val city = getCityUseCase(cityId)
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