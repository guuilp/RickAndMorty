package guuilp.github.com.rickandmorty

import android.app.Application
import guuilp.github.com.data.di.dataModule
import guuilp.github.com.domain.di.domainModule
import guuilp.github.com.remote.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

val applicationModules = listOf(remoteModule, dataModule, domainModule)

class RickAndMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RickAndMortyApplication)
            modules(applicationModules)
        }
    }
}