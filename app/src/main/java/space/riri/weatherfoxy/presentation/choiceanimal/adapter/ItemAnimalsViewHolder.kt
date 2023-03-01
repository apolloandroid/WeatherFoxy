package space.riri.weatherfoxy.presentation.choiceanimal.adapter

import androidx.recyclerview.widget.RecyclerView
import space.riri.weatherfoxy.data.model.AnimalsDataModel
import space.riri.weatherfoxy.databinding.ItemChoiceAnimalsBinding
import space.riri.weatherfoxy.presentation.choiceanimal.model.ItemAnimalsModel

class ItemAnimalsViewHolder(
    private val binding: ItemChoiceAnimalsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ItemAnimalsModel, onAnimalSelected: (AnimalsDataModel) -> Unit) {
        binding.checkbox.apply {
            isChecked = item.isCurrent
            setOnClickListener { onAnimalSelected(item.animal) }
        }
        binding.icon.setImageResource(item.animal.iconAnimal)
    }
}