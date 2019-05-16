package com.hartleylab.weatherkotlinapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hartleylab.weatherkotlinapp.R
import com.hartleylab.weatherkotlinapp.domain.model.ForecastList
import com.hartleylab.weatherkotlinapp.domain.model.ModelForecast
import com.hartleylab.weatherkotlinapp.ui.App
import com.hartleylab.weatherkotlinapp.ui.utility.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*
import org.jetbrains.anko.find

class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (ModelForecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount() = weekForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    class ViewHolder(view: View, val itemClick: (ModelForecast) -> Unit): RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: ModelForecast) {
            with(forecast) {
                Picasso.get().load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }
}