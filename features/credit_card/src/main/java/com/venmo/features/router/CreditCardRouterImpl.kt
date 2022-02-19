package com.venmo.features.router

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.venmo.commons.navigation.routers.CreditCardRouter
import com.venmo.entities.User
import com.venmo.features.credit_card.R

class CreditCardRouterImpl: CreditCardRouter {
    override fun navigate(user: User, navController: NavController) {
        navController.navigate(R.id.nav_graph_credit_card, bundleOf("user" to user))
    }
}