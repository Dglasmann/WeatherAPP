package com.dglasmann.weatherapp.domain

class GetCitiesUseCase(private val cityRepository: CityRepository) {
    operator fun invoke() = cityRepository.getCities()
}