package com.dglasmann.weatherapp.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dglasmann.weatherapp.model.City
import com.dglasmann.weatherapp.R

class CityAdapter(private val onItemClick: (City) -> Unit) :RecyclerView.Adapter<CityAdapter.CityHolder>() {

    var cities: List<City> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        val city = cities[position]
        holder.bind(city)
    }

    class CityHolder(itemView: View, val onItemClick: (City) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val nameText = itemView.findViewById<TextView>(R.id.name_text)
        private val temperatureText = itemView.findViewById<TextView>(R.id.temperature_text)

        fun bind(city: City) {
            nameText.text = itemView.context.getString(R.string.city_format, city.name)
            temperatureText.text = city.temperature
            itemView.setOnClickListener { onItemClick(city) }
        }
    }

    override fun getItemCount(): Int = cities.count()
}
