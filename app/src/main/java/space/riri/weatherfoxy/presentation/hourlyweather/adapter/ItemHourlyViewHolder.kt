package space.riri.weatherfoxy.presentation.hourlyweather.adapter

import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import space.riri.weatherfoxy.R
import space.riri.weatherfoxy.databinding.ItemHourlyWeatherBinding
import space.riri.weatherfoxy.presentation.hourlyweather.model.ItemHourlyModel
import space.riri.weatherfoxy.utils.setImageDrawable

class ItemHourlyViewHolder(
    private val binding: ItemHourlyWeatherBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ItemHourlyModel) {

        val additionalInfoRes = itemView.resources.getString(R.string.additional_info)
        val infoRes = itemView.resources.getString(R.string.day_info)
        val clockDRes = itemView.resources.getString(R.string.clock_d)
        val partlyCloudyRes = itemView.resources.getString(R.string.partly_cloudy)
        val day = String.format(clockDRes, item.time)
        val partlyCloudyText = String.format(partlyCloudyRes)
        val info = String.format(infoRes, item.precipitation, item.humidity, item.uvIndex)
        val additionalInfoText = String.format(additionalInfoRes, item.pressure, item.visibility)

        with(binding) {
            clockD.text = day
            partlyCloudy.text = partlyCloudyText
            dayInfo.text = info
            clockTemper.text = item.temperature.toString()
            additionalInfo.text = additionalInfoText
            item.iconHourly?.let{
                cloudSun.setImageDrawable(item.iconHourly)
            }
           cloudSun.isGone = item.iconHourly == null
        }
    }
}