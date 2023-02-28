package space.riri.weatherfoxy.presentation.choiceanimal.mapper

import space.riri.weatherfoxy.data.model.AnimalsDataModel
import space.riri.weatherfoxy.presentation.choiceanimal.model.ItemAnimalsModel


import javax.inject.Inject

class ChoiceAnimalsItemMapper @Inject constructor() {

    fun map(dataModels: List<AnimalsDataModel>) : List<ItemAnimalsModel> {
        return dataModels.map(::mapToItem)
    }

    private fun mapToItem(dataModel: AnimalsDataModel) : ItemAnimalsModel {
        return ItemAnimalsModel(
           iconAnimal = dataModel.iconAnimal,
            isCurrent = false
        )
    }
}