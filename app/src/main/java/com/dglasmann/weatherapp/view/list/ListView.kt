package com.dglasmann.weatherapp.list
import com.dglasmann.weatherapp.presenter.BaseView
import com.dglasmann.weatherapp.model.City

interface ListView: BaseView {
    fun bindCityList(list: List<City>)
    fun openDetailsScreen(cityId: Long)
}