package space.riri.weatherfoxy.data.repo

import space.riri.weatherfoxy.data.model.AnimalsDataModel

interface UserRepository {

    fun putCurrentAnimals(animalsDataModel: AnimalsDataModel)

    fun getCurrentAnimals(): AnimalsDataModel
}