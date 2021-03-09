package com.dglasmann.weatherapp.presentation.list
import com.dglasmann.weatherapp.presentation.BaseView
import com.dglasmann.weatherapp.domain.model.City

interface ListView: BaseView {
    fun bindCityList(list: List<City>)
    fun openDetailsScreen(name: String)
}