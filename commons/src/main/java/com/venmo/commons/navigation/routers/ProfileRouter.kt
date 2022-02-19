package com.venmo.commons.navigation.routers

import androidx.navigation.NavController
import com.venmo.entities.User

interface ProfileRouter {
    fun navigate(navController: NavController)
    fun navigate(id: String)
    fun navigate(user: User)
}