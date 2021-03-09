package com.dglasmann.weatherapp.domain.model

data class City (
    val id: Long,
    val name: String,
    val main: Main,
    val sys: Sys,
    val weather: List<Weather>
)