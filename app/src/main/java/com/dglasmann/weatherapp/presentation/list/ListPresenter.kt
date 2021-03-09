package com.dglasmann.weatherapp.presentation.list

import androidx.lifecycle.MutableLiveData
import com.dglasmann.weatherapp.domain.model.City
import com.dglasmann.weatherapp.domain.GetCitiesUseCase
import com.dglasmann.weatherapp.presentation.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListPresenter(private val getCitiesUseCase: GetCitiesUseCase) : BasePresenter<ListView>() {

    val cityList = MutableLiveData<List<City>>()
    val loading = MutableLiveData<Boolean>()

    fun onViewResumed() {
        loading.value = true
        getCitiesUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate {
                loading.value = false
            }
            .subscribe({
                view?.bindCityList(it.list)
                cityList.value = it.list
            }, {})
            .untilDestroy()
    }

    fun onCityClicked(city: City) {
        view?.openDetailsScreen(city.name)
    }

}