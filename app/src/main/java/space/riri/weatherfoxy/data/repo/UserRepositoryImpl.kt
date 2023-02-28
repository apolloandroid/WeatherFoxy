package space.riri.weatherfoxy.data.repo

import space.riri.weatherfoxy.data.model.AnimalsDataModel
import space.riri.weatherfoxy.data.preference.UserPreference

class UserRepositoryImpl(
    private val sharedPreference: UserPreference


) : UserRepository {
    override fun putCurrentAnimals(animalsDataModel: AnimalsDataModel) {
        sharedPreference.putCurrentAnimals(animalsDataModel)
    }

    override fun getCurrentAnimals(): AnimalsDataModel {
        return sharedPreference.getCurrentAnimals()
    }
}