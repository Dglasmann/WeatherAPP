package com.dglasmann.weatherapp.data

import com.dglasmann.weatherapp.domain.City

class CityLocalDataSource: CityDataSource {

    private val cities = mutableListOf(
            City(0, "Novosibirsk", "-15", "cloudy"),
            City(1, "Bratsk", "-30", "snowy"),
            City(2, "Irkutsk", "-25", "sunny"),
            City(3, "Moscow", "+5", "cloudy"),
            City(4, "Omsk", "-5", "sunny"),
            City(5, "Tomsk", "-15", "snowy"),
    )

    override fun getCity(id: Long): City? = cities.firstOrNull() { it.id == id }

    override fun getCities(): List<City> = cities

}