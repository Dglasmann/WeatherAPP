package com.dglasmann.weatherapp.domain

class GetCityUseCase(private val cityRepository: CityRepository) {
    operator fun invoke(id: Long) = cityRepository.getCity(id)
}