package space.riri.weatherfoxy.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import space.riri.weatherfoxy.di.DaggerAppComponent

@HiltAndroidApp
class HiltApplication: Application() {

    override fun onCreate() {
        super.onCreate()
       DaggerAppComponent.factory().create(this).inject(this
       )
    }
}