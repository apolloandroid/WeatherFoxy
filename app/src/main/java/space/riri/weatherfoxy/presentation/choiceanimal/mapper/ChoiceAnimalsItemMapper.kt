package space.riri.weatherfoxy.presentation.choiceanimal.mapper

import space.riri.weatherfoxy.data.model.AnimalsDataModel
import space.riri.weatherfoxy.presentation.choiceanimal.model.ItemAnimalsModel


import javax.inject.Inject

class ChoiceAnimalsItemMapper @Inject constructor() {

    fun map(
        animals: List<AnimalsDataModel>,
        currentAnimal: AnimalsDataModel
    ): List<ItemAnimalsModel> {
        return animals.map {
            ItemAnimalsModel(
                animal = it,
                isCurrent = it == currentAnimal
            )
        }
    }
}