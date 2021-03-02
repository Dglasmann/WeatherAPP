package com.dglasmann.weatherapp.model

class CityRepository {
    private val cities = mutableListOf(
        City(0, "Novosibirsk", "-15", "cloudy"),
        City(1, "Bratsk", "-30", "snowy"),
        City(2, "Irkutsk", "-25", "sunny"),
        City(3, "Moscow", "+5", "cloudy"),
        City(4, "Omsk", "-5", "sunny"),
        City(5, "Tomsk", "-15", "snowy"),
    )

    fun getCity(id: Long): City? = cities.firstOrNull() { it.id == id }

    fun getCities(): List<City> = cities
}