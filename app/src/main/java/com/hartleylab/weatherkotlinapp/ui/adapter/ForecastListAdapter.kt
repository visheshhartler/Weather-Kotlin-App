package com.hartleylab.weatherkotlinapp.ui.adapter

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hartleylab.weatherkotlinapp.domain.model.ForecastList

class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount() = weekForecast.dailyForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       with(weekForecast.dailyForecast[position]) {
           holder.textView.text = "$date - $description - $high/$low"
       }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}