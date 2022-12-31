package space.riri.weatherfoxy.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import space.riri.weatherfoxy.core.HiltApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {

        fun create (@BindsInstance context: Context) : AppComponent
    }

    fun inject (app: HiltApplication)
}