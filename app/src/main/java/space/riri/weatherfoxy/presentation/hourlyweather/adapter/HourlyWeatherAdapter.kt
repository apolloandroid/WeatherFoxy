package space.riri.weatherfoxy.presentation.hourlyweather.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.riri.weatherfoxy.databinding.ItemHourlyWeatherBinding
import space.riri.weatherfoxy.presentation.hourlyweather.model.ItemHourlyModel

class HourlyWeatherAdapter : RecyclerView.Adapter<ItemHourlyViewHolder>() {

    private val hourlyItems = mutableListOf<ItemHourlyModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: List<ItemHourlyModel>) {
        hourlyItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemHourlyViewHolder {
       val binding = ItemHourlyWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHourlyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ItemHourlyViewHolder,
        position: Int
    ) {
        holder.bind(hourlyItems[position])
    }

    override fun getItemCount(): Int = hourlyItems.size


}