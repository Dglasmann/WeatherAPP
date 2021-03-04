package com.dglasmann.weatherapp.domain

data class City (
    val id: Long,
    val name: String,
    val temperature: String,
    val fallout: String
)