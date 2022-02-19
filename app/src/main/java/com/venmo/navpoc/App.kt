package com.venmo.navpoc

import android.app.Application
import com.venmo.features.di.CreditCardModuleProvider.creditCardModule
import com.venmo.features.di.ProfileModuleProvider.profileModule
import com.venmo.features.di.SettingsModuleProvider.settingsModule
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin { koin.loadModules(featureModules) }
    }
}

val featureModules = listOf(
    profileModule,
    creditCardModule,
    settingsModule
)