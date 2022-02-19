package com.venmo.features.router

import androidx.navigation.NavController
import com.venmo.commons.navigation.routers.AddCreditCardRouter
import com.venmo.features.credit_card.R

class AddCreditCardRouterImpl: AddCreditCardRouter {
    override fun navigate(navController: NavController) {
        navController.navigate(R.id.nav_graph_add_credit_card)
    }
}