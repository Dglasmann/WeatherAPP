package com.dglasmann.weatherapp.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dglasmann.weatherapp.domain.model.City
import com.dglasmann.weatherapp.R
import com.dglasmann.weatherapp.databinding.ItemCityBinding
import com.squareup.picasso.Picasso

class CityAdapter(private val onClick: (City) -> Unit) : RecyclerView.Adapter<CityHolder>() {

    var cities: List<City> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemViewBinding = ItemCityBinding.inflate(layoutInflater, parent, false)
        return CityHolder(itemViewBinding, onClick)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        val person = cities[position]
        holder.bind(person)
    }

    override fun getItemCount(): Int = cities.count()
}

class CityHolder(
    private val itemViewBinding: ItemCityBinding,
    private val onClick: (City) -> Unit
) : RecyclerView.ViewHolder(itemViewBinding.root) {

    fun bind(city: City) {
        itemViewBinding.cityText.text = city.name
        itemViewBinding.temperatureText.text = itemView.context.getString(
            R.string.temperature_format,
            (city.main.temp - 273).toInt().toString()
        )
        val url = "http://openweathermap.org/img/wn/${city.weather[0].icon}@2x.png"
        Picasso.with(itemView.context).load(url).resize(128, 128).into(itemViewBinding.condPng)
        itemView.setOnClickListener { onClick(city) }
    }
}