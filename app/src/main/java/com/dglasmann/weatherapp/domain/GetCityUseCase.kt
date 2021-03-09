package com.dglasmann.weatherapp.domain

class GetCityUseCase(private val cityRepository: CityRepository) {
    operator fun invoke(name: String) = cityRepository.getCity(name)
}