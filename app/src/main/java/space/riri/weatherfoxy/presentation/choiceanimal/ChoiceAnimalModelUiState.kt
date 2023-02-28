package space.riri.weatherfoxy.presentation.choiceanimal

import space.riri.weatherfoxy.presentation.choiceanimal.model.ItemAnimalsModel


data class ChoiceAnimalModelUiState(
    val isLoading : Boolean = false,
    val isError: Boolean = false,
    val items: List<ItemAnimalsModel> = emptyList()
)
