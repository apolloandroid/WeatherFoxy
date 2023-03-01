package space.riri.weatherfoxy.domain

import space.riri.weatherfoxy.data.model.AnimalsDataModel
import space.riri.weatherfoxy.data.repo.UserRepository
import javax.inject.Inject

class GetAnimalsUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    fun getAnimals(): List<AnimalsDataModel> = userRepository.getAnimals()
}