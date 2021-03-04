package com.dglasmann.weatherapp.presentation.details

import com.dglasmann.weatherapp.presentation.BaseView
import com.dglasmann.weatherapp.domain.City

interface DetailView: BaseView {
    fun bindCity(city: City)

    fun closeScreen()
}