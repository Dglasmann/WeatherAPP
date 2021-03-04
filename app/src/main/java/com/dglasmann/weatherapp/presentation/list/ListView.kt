package com.dglasmann.weatherapp.presentation.list
import com.dglasmann.weatherapp.presentation.BaseView
import com.dglasmann.weatherapp.domain.City

interface ListView: BaseView {
    fun bindCityList(list: List<City>)
    fun openDetailsScreen(cityId: Long)
}