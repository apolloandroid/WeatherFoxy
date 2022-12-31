package space.riri.weatherfoxy.presentation.currentweather.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.riri.weatherfoxy.databinding.ItemWeatherBinding
import space.riri.weatherfoxy.presentation.currentweather.model.ItemWeatherModel

class CurrentWeatherAdapter : RecyclerView.Adapter<CurrentWeatherViewHolder>() {
    private val itemsList = mutableListOf<ItemWeatherModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: List<ItemWeatherModel>) {
        itemsList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentWeatherViewHolder {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrentWeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrentWeatherViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}