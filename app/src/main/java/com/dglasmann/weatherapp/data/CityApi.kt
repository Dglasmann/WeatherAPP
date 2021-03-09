package com.dglasmann.weatherapp.data

import com.dglasmann.weatherapp.domain.model.City
import com.dglasmann.weatherapp.domain.model.HTTPResponse
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi {

    companion object {
        const val KEY = "2eda13f098e712b4a3a1264a6b3d1e7b"
    }

    @GET("find")
    fun getCitiesList(@Query("lat") lat: Int = 55,
                      @Query("lon") lon: Int = 83,
                      @Query("cnt") cnt: Int = 20,
                      @Query("appid") appid: String = KEY
    ): Single<HTTPResponse>

    @GET("weather")
    fun getCity(@Query("q") name: String,
                @Query("appid") appid: String = KEY
    ): Single<City>
}