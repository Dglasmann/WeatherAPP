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
        private lateinit var cityList: RecyclerView
        private lateinit var swipeRefresh: SwipeRefreshLayout
        private lateinit var activityMainBinding: ActivityMainBinding
        private val adapter = CityAdapter {
                presenter.onCityClicked(it)
        }

        private val swipeHelper = object : ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT
        ) {
                override fun onMove(
                        recyclerView: RecyclerView,
                        viewHolder: RecyclerView.ViewHolder,
                        target: RecyclerView.ViewHolder
                ): Boolean {
                        return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                        val position = viewHolder.adapterPosition
                }
        }
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                swipeRefresh = findViewById(R.id.swipeRefresh)
                activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(activityMainBinding.root)
                presenter.attachView(this)
                initViews()
                presenter.loading.observe(this) {
                        activityMainBinding.cityList.isVisible = !it
                        swipeRefresh.isRefreshing = it
                }

                ItemTouchHelper(swipeHelper).attachToRecyclerView(cityList)
                swipeRefresh.setOnRefreshListener {
                        presenter.onViewResumed()
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
