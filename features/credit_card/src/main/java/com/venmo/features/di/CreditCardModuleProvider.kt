package com.venmo.features.di

import com.venmo.commons.navigation.routers.AddCreditCardRouter
import com.venmo.commons.navigation.routers.CreditCardRouter
import com.venmo.features.credit_card.CreditCardViewModel
import com.venmo.features.router.AddCreditCardRouterImpl
import com.venmo.features.router.CreditCardRouterImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object CreditCardModuleProvider {
    val creditCardModule = module {
        single<CreditCardRouter>{ CreditCardRouterImpl() }
        single<AddCreditCardRouter> { AddCreditCardRouterImpl() }
        viewModel { CreditCardViewModel(get()) }
    }
}
