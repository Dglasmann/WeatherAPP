package com.dglasmann.weatherapp.presentation.details

import androidx.lifecycle.MutableLiveData
import com.dglasmann.weatherapp.domain.GetCityUseCase
import com.dglasmann.weatherapp.presentation.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsPresenter(
    private val getCityUseCase: GetCityUseCase,
    private val cityName: String
): BasePresenter<DetailView>() {

    val loading = MutableLiveData<Boolean>()

    override fun onViewAttached() {
        loading.value = true
        getCityUseCase(cityName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate {
                loading.value = false
            }
            .subscribe({
                view?.bindCity(it)
            }, {
                view?.closeScreen()
            })
            .untilDestroy()
    }

    fun getBack() {
        view?.closeScreen()
    }
}