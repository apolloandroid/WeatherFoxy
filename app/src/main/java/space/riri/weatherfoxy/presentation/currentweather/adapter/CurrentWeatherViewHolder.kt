package space.riri.weatherfoxy.presentation.currentweather.adapter

import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import space.riri.weatherfoxy.databinding.ItemWeatherBinding
import space.riri.weatherfoxy.presentation.currentweather.model.ItemWeatherModel
import space.riri.weatherfoxy.utils.setImageDrawable

class CurrentWeatherViewHolder(
    private val binding: ItemWeatherBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ItemWeatherModel) {
        with(binding){
            dayOfWeek.text = item.day
            tempDay.text = item.temp
            item.iconRes?.let {
                weatherIconDay.setImageDrawable(item.iconRes)
            }
            weatherIconDay.isGone = item.iconRes == null
        }
    }
}