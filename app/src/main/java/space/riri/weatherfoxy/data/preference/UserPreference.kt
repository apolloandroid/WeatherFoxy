package space.riri.weatherfoxy.data.preference

import android.content.Context
import android.content.Context.MODE_PRIVATE
import dagger.hilt.android.qualifiers.ApplicationContext
import space.riri.weatherfoxy.data.model.AnimalsDataModel
import javax.inject.Inject


private const val USER_PREFERENCE_KEY = "USER_PREFERENCE_KEY"
private const val CURRENT_ANIMALS = "CURRENT_ANIMALS"
private const val DEFAULT_ANIMALS = "BUNNY"

class UserPreference @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val preference = context.getSharedPreferences(USER_PREFERENCE_KEY, MODE_PRIVATE)

    fun putCurrentAnimals(animalsDataModel: AnimalsDataModel) {
        val editor = preference.edit()
        editor.putString(CURRENT_ANIMALS, animalsDataModel.toString())
        editor.apply()
    }

    fun getCurrentAnimals(): AnimalsDataModel {
        val currentAnimals = preference.getString(CURRENT_ANIMALS, "BUNNY") ?: DEFAULT_ANIMALS
        return AnimalsDataModel.valueOf(currentAnimals)
    }
}