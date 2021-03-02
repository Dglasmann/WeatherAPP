package com.dglasmann.weatherapp.view.detail

import com.dglasmann.weatherapp.presenter.BaseView
import com.dglasmann.weatherapp.model.City

interface DetailView: BaseView {
    fun bindCity(city: City)

    fun closeScreen()
}