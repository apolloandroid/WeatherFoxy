package space.riri.weatherfoxy.domain

import space.riri.weatherfoxy.data.model.AnimalsDataModel
import space.riri.weatherfoxy.data.repo.UserRepository
import javax.inject.Inject

class SetSelectedAnimalUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    fun setSelectedAnimal(animal: AnimalsDataModel) = userRepository.setCurrentAnimal(animal)
}