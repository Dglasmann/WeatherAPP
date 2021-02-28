package com.dglasmann.weatherapp.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dglasmann.weatherapp.CityApplication
import com.dglasmann.weatherapp.CityRepository
import com.dglasmann.weatherapp.R

class DetailActivity : AppCompatActivity() {
companion object {
private const val EXTRA_ID = "EXTRA_ID"

    fun start(context: Context, id: Long) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        context.startActivity(intent)
    }
}
    lateinit var nameText:TextView
    lateinit var temperatureText:TextView
    lateinit var falloutText:TextView
    lateinit var backbtn:TextView
    lateinit var cityRepository: CityRepository



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        cityRepository = (application as CityApplication).cityRepository
        nameText = findViewById(R.id.name_text)
        temperatureText = findViewById(R.id.temperature_text)
        falloutText = findViewById(R.id.fallout_text)
        backbtn = findViewById(R.id.back_button)
        backbtn.setOnClickListener{
            finish()
        }
        initCity()
    }
private fun initCity() {
        val id = intent.getLongExtra(EXTRA_ID,0)
        val city = cityRepository.getCity(id)
    if (city != null) {
            nameText.text = getString(R.string.city_format, city.name)
            temperatureText.text = getString(R.string.temperature_format, city.temperature)
            falloutText.text = getString(R.string.fallout_format, city.fallout)
    } else {
        finish()
        }
    }
}