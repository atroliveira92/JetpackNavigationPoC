package com.venmo.features.di

import com.venmo.commons.navigation.routers.SettingsRouter
import com.venmo.features.router.SettingsRouterImpl
import org.koin.dsl.module

object SettingsModuleProvider {
    val settingsModule = module {
        single<SettingsRouter> { SettingsRouterImpl() }
    }
}