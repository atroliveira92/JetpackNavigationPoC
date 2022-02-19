package com.venmo.features.di

import com.venmo.commons.navigation.routers.ProfileRouter
import com.venmo.features.router.ProfileRouterImpl
import org.koin.dsl.module

object ProfileModuleProvider {
    val profileModule = module {
        single<ProfileRouter> { ProfileRouterImpl() }
    }
}