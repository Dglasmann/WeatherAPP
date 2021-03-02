package com.dglasmann.weatherapp

open class BasePresenter<View: BaseView> {
    var view: View? = null

    fun attachView(view: View) {
        this.view = view
        onViewAttached()
    }

    open fun onViewAttached() {}

    fun destroy() {
        this.view = null
    }
}