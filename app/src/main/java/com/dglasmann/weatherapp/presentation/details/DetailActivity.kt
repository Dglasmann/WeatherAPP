package com.dglasmann.weatherapp.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dglasmann.weatherapp.R
import com.dglasmann.weatherapp.domain.City

class DetailActivity : AppCompatActivity(), DetailView {
companion object {
private const val EXTRA_ID = "EXTRA_ID"

    fun start(context: Context, id: Long) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        context.startActivity(intent)
    }
}
    private val presenter by lazy {
        DetailsPresenterFactory.getPresenter(intent.getLongExtra(EXTRA_ID, 0    ))
    }
    lateinit var nameText:TextView
    lateinit var temperatureText:TextView
    lateinit var falloutText:TextView
    lateinit var backbtn:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initCity()
        presenter.attachView(this)
    }
    private fun initCity() {
        nameText = findViewById(R.id.name_text)
        temperatureText = findViewById(R.id.temperature_text)
        falloutText = findViewById(R.id.fallout_text)
        backbtn = findViewById(R.id.back_button)
    }

    override fun bindCity(city: City) {
        nameText.text = getString(R.string.city_format, city.name)
        temperatureText.text = getString(R.string.temperature_format, city.temperature)
        falloutText.text = getString(R.string.fallout_format, city.fallout)
        backbtn.setOnClickListener {
            presenter.getBack()
        }
    }

    override fun closeScreen() {
        finish()
    }
}