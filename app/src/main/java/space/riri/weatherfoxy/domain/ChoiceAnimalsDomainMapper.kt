package space.riri.weatherfoxy.domain

import space.riri.weatherfoxy.data.model.AnimalsDataModel

class ChoiceAnimalsDomainMapper {

    fun map(item: AnimalsDataModel) = ChoiceAnimalsDomainModel(
        ChoiceAnimalsDomainModel(
            iconAnimal = item.iconAnimal,
            current = item.current
        )

    )
}