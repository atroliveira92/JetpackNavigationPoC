package com.venmo.commons.navigation.routers

import androidx.navigation.NavController
import com.venmo.entities.User

interface AddCreditCardRouter {
    fun navigate(navController: NavController)
}

interface CreditCardRouter {
    fun navigate(user: User, navController: NavController)
}