package space.riri.weatherfoxy.presentation.choiceanimal.model

import androidx.annotation.DrawableRes

data class ItemAnimalsModel(
    val isCurrent: Boolean,
    @DrawableRes
    val iconAnimal: Int
)
