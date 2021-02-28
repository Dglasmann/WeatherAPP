package com.dglasmann.weatherapp.list

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dglasmann.weatherapp.CityApplication
import com.dglasmann.weatherapp.CityRepository
import com.dglasmann.weatherapp.R
import com.dglasmann.weatherapp.detail.DetailActivity

class ListActivity: AppCompatActivity() {
        private lateinit var cityRepository: CityRepository
        private lateinit var citiesList: RecyclerView
        private val adapter = CityAdapter {
                DetailActivity.start(this,it.id)
        }

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState,)
                setContentView(R.layout.activity_list)

                cityRepository = (application as CityApplication).cityRepository
                citiesList = findViewById(R.id.cities_list)
                citiesList.adapter = adapter
                citiesList.layoutManager = LinearLayoutManager(this)
        }
        override fun onResume() {
                super.onResume()
                adapter.cities = cityRepository.getCities()
        }
}