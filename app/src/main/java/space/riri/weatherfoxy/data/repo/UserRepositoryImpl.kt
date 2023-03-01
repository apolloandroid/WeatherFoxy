package space.riri.weatherfoxy.data.repo

import space.riri.weatherfoxy.data.model.AnimalsDataModel
import space.riri.weatherfoxy.data.preference.UserPreference

// AnimalRepository
class UserRepositoryImpl(
    private val userPreference: UserPreference
) : UserRepository {

    override fun setCurrentAnimal(animalsDataModel: AnimalsDataModel) {
        userPreference.putCurrentAnimals(animalsDataModel)
    }

    override fun getCurrentAnimal(): AnimalsDataModel {
        return userPreference.getCurrentAnimals()
    }

    override fun getAnimals(): List<AnimalsDataModel> {
        return listOf(
            AnimalsDataModel.BUNNY,
            AnimalsDataModel.CAT,
            AnimalsDataModel.HEDGEHOG,
            AnimalsDataModel.PENGUIN,
            AnimalsDataModel.PUPPY,
            AnimalsDataModel.FOX
        )
    }
}