package com.hartleylab.weatherkotlinapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hartleylab.weatherkotlinapp.ui.adapter.ForecastListAdapter
import com.hartleylab.weatherkotlinapp.R
import com.hartleylab.weatherkotlinapp.domain.commands.RequestForecastCommand
import com.hartleylab.weatherkotlinapp.domain.model.ModelForecast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result) { modelForecast ->
                    toast(modelForecast.description)
                }
            }
        }
    }
}
