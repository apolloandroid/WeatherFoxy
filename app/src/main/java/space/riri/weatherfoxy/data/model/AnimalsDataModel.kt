package space.riri.weatherfoxy.data.model

import androidx.annotation.DrawableRes
import space.riri.weatherfoxy.R

enum class AnimalsDataModel(
    @DrawableRes
    val iconAnimal: Int
    ) {
    BUNNY(R.drawable.ic_bunny),
    CAT(R.drawable.ic_cat),
    HEDGEHOG(R.drawable.ic_hedgehog),
    PENGUIN(R.drawable.ic_penguin),
    PUPPY(R.drawable.ic_puppy)
}
