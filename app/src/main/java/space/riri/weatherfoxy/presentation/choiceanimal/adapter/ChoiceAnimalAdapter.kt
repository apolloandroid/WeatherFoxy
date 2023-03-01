package space.riri.weatherfoxy.presentation.choiceanimal.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.riri.weatherfoxy.data.model.AnimalsDataModel
import space.riri.weatherfoxy.databinding.ItemChoiceAnimalsBinding
import space.riri.weatherfoxy.presentation.choiceanimal.model.ItemAnimalsModel


class ChoiceAnimalAdapter(
    private val onAnimalSelected: (AnimalsDataModel) -> Unit
) : RecyclerView.Adapter<ItemAnimalsViewHolder>() {

    private val animalsItem = mutableListOf<ItemAnimalsModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: List<ItemAnimalsModel>) {
        animalsItem.clear()
        animalsItem.addAll(items)
        /**
         * // плохой метод, используй [ListAdapter]
         */
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAnimalsViewHolder {
        val binding =
            ItemChoiceAnimalsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemAnimalsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemAnimalsViewHolder, position: Int) {
        holder.bind(animalsItem[position], onAnimalSelected)
    }

    override fun getItemCount(): Int = animalsItem.size

}