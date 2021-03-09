package com.dglasmann.weatherapp.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.dglasmann.weatherapp.R
import com.dglasmann.weatherapp.databinding.ActivityDetailsBinding
import com.dglasmann.weatherapp.domain.model.City
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity(), DetailView {

    companion object {

        private const val EXTRA_NAME = "EXTRA_NAME"

        fun start(context: Context, name: String) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_NAME, name)
            context.startActivity(intent)
        }
    }

    private val presenter by lazy {
        DetailPresenterFactory.getPresenter(intent.getStringExtra(EXTRA_NAME) ?: "Unknown")
    }

    private lateinit var activityDetailBinding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        presenter.loading.observe(this) {
            activityDetailBinding.content.isVisible = !it
            activityDetailBinding.progressCircular.isVisible = it
        }
        presenter.attachView(this)
    }

    override fun bindCity(city: City) {
        activityDetailBinding.cityNameText.text = city.name
        activityDetailBinding.cityTemperatureText.text =
            getString(R.string.temperature_format, (city.main.temp - 273).toInt().toString())
        activityDetailBinding.cityCountryText.text = city.sys.country
        activityDetailBinding.cityFalloutText.text =
            getString(R.string.fallout_format, city.weather[0].description)
        val url = "http://openweathermap.org/img/wn/${city.weather[0].icon}@2x.png"
        Picasso.with(this).load(url).resize(128, 128).into(activityDetailBinding.weatherPng)
        activityDetailBinding.backButton.setOnClickListener {
            presenter.getBack()
        }
    }

    override fun closeScreen() {
        finish()
    }
}