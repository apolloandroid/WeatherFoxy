package space.riri.weatherfoxy.presentation.choiceanimal.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.riri.weatherfoxy.databinding.ChoiceAnimalBinding
import space.riri.weatherfoxy.presentation.choiceanimal.model.ItemAnimalsModel


class ChoiceAnimalAdapter : RecyclerView.Adapter<ItemAnimalsViewHolder>() {

    private val animalsItem = mutableListOf<ItemAnimalsModel> ()

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: List<ItemAnimalsModel>) {
        animalsItem.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAnimalsViewHolder {
       val binding = ChoiceAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemAnimalsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemAnimalsViewHolder, position: Int) {
        holder.bind(animalsItem[position])
    }

    override fun getItemCount(): Int = animalsItem.size

}