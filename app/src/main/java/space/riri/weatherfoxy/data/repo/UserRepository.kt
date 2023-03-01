package space.riri.weatherfoxy.data.repo

import space.riri.weatherfoxy.data.model.AnimalsDataModel

interface UserRepository {

    fun setCurrentAnimal(animalsDataModel: AnimalsDataModel)

    fun getCurrentAnimal(): AnimalsDataModel

    fun getAnimals(): List<AnimalsDataModel>
}