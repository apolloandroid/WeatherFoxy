package space.riri.weatherfoxy.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import space.riri.weatherfoxy.databinding.ItemWeatherBinding

fun ImageView.setImageDrawable(@DrawableRes iconRes: Int) {
    val resources = resources
    val theme = context.theme
    val drawable = ResourcesCompat.getDrawable(resources, iconRes, theme)
    setImageDrawable(drawable)
}