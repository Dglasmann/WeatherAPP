package com.dglasmann.weatherapp.view.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dglasmann.weatherapp.presenter.ListPresenter
import com.dglasmann.weatherapp.model.CityApplication
import com.dglasmann.weatherapp.R
import com.dglasmann.weatherapp.view.detail.DetailActivity
import com.dglasmann.weatherapp.model.City

class ListActivity: AppCompatActivity(), ListView {

        private val presenter by lazy {
                ListPresenter((application as CityApplication).cityRepository)
        }

        private val adapter by lazy {  CityAdapter(presenter::onCityClicked) }
        private lateinit var citiesList: RecyclerView

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState,)
                setContentView(R.layout.activity_list)
                citiesList = findViewById(R.id.cities_list)
                citiesList.adapter = adapter
                citiesList.layoutManager = LinearLayoutManager(this)
                presenter.attachView(this)
        }
        override fun onResume() {
                super.onResume()
                presenter.onViewResumed()
        }

        override fun bindCityList(list: List<City>) {
                adapter.cities = list
        }

        override fun openDetailsScreen(cityId: Long) {
                DetailActivity.start(this, cityId)
        }
}