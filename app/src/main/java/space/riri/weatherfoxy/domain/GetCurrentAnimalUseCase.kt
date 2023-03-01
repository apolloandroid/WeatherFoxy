package space.riri.weatherfoxy.domain

import space.riri.weatherfoxy.data.model.AnimalsDataModel
import space.riri.weatherfoxy.data.repo.UserRepository
import javax.inject.Inject

class GetCurrentAnimalUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    fun getAnimal(): AnimalsDataModel = userRepository.getCurrentAnimal()
}