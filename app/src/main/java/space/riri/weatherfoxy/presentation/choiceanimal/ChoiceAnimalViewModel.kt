package space.riri.weatherfoxy.presentation.choiceanimal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import space.riri.weatherfoxy.data.repo.WeatherRepository
import space.riri.weatherfoxy.presentation.choiceanimal.mapper.ChoiceAnimalsItemMapper
import javax.inject.Inject

@HiltViewModel
class ChoiceAnimalViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val itemMapper: ChoiceAnimalsItemMapper
) : ViewModel() {

    private val mutableUiState = MutableLiveData<ChoiceAnimalModelUiState>()
    val uiState: LiveData<ChoiceAnimalModelUiState> = mutableUiState

    fun onViewCreated() {
        mutableUiState.value = ChoiceAnimalModelUiState(isLoading = true)
        viewModelScope.launch {
            try {
                mutableUiState.value
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }

    }
}