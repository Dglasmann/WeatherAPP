package com.dglasmann.weatherapp.presentation.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.dglasmann.weatherapp.R
import com.dglasmann.weatherapp.databinding.ActivityMainBinding
import com.dglasmann.weatherapp.presentation.details.DetailActivity
import com.dglasmann.weatherapp.domain.model.City

class ListActivity : AppCompatActivity(), ListView {

        private val presenter by lazy {
                ListPresenterFactory.getPresenter()
        }
        private lateinit var swipeRefreshLayout: SwipeRefreshLayout
        private lateinit var activityMainBinding: ActivityMainBinding
        private val adapter = CityAdapter {
                presenter.onCityClicked(it)
        }

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(activityMainBinding.root)
                swipeRefreshLayout = findViewById(R.id.swipeRefresh)
                swipeRefreshLayout.setOnRefreshListener {
                        presenter.onViewResumed()
                        swipeRefreshLayout.isRefreshing = false
                }
                presenter.attachView(this)
                initViews()
                presenter.loading.observe(this) {
                        activityMainBinding.cityList.isVisible = !it
                        activityMainBinding.progressCircularList.isVisible = it
                }
        }

        private fun initViews() {
                activityMainBinding.cityList.adapter = adapter
                activityMainBinding.cityList.layoutManager = LinearLayoutManager(this)

        }

        override fun onResume() {
                super.onResume()
                presenter.onViewResumed()
        }

        override fun bindCityList(list: List<City>) {
                adapter.cities = list
        }

        override fun openDetailsScreen(name: String) {
                DetailActivity.start(this, name)
        }
}
