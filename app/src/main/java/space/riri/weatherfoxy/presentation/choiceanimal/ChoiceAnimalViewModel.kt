package space.riri.weatherfoxy.presentation.choiceanimal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import space.riri.weatherfoxy.data.model.AnimalsDataModel
import space.riri.weatherfoxy.data.repo.WeatherRepository
import space.riri.weatherfoxy.domain.GetAnimalsUseCase
import space.riri.weatherfoxy.domain.GetCurrentAnimalUseCase
import space.riri.weatherfoxy.domain.SetSelectedAnimalUseCase
import space.riri.weatherfoxy.presentation.choiceanimal.mapper.ChoiceAnimalsItemMapper
import space.riri.weatherfoxy.presentation.choiceanimal.model.ItemAnimalsModel
import javax.inject.Inject

@HiltViewModel
class ChoiceAnimalViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val getCurrentAnimalUseCase: GetCurrentAnimalUseCase,
    private val getAnimalsUseCase: GetAnimalsUseCase,
    private val setSelectedAnimalUseCase: SetSelectedAnimalUseCase,
    private val itemMapper: ChoiceAnimalsItemMapper
) : ViewModel() {

    private val _uiState = MutableLiveData<ChoiceAnimalModelUiState>()
    val uiState: LiveData<ChoiceAnimalModelUiState> = _uiState


    init {
        updateAnimals()
    }

    fun onAnimalSelected(animal: AnimalsDataModel) {
        setSelectedAnimalUseCase.setSelectedAnimal(animal)
        updateAnimals()
    }

    private fun updateAnimals() {
        _uiState.value = ChoiceAnimalModelUiState(isLoading = true)
        val animals = getAnimalsUseCase.getAnimals()
        val currentAnimal = getCurrentAnimalUseCase.getAnimal()
        val items: List<ItemAnimalsModel> = itemMapper.map(animals, currentAnimal)
        _uiState.value = ChoiceAnimalModelUiState(isLoading = false, items = items)
    }
}