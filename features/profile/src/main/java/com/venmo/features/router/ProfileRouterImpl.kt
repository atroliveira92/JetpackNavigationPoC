package com.venmo.features.router

import androidx.navigation.NavController
import com.venmo.commons.navigation.routers.ProfileRouter
import com.venmo.entities.User
import com.venmo.features.profile.R

class ProfileRouterImpl: ProfileRouter {

    override fun navigate(navController: NavController) {
        navController.navigate(R.id.nav_graph_profile)
    }

    override fun navigate(id: String) {
        TODO("Not yet implemented")
    }

    override fun navigate(user: com.venmo.entities.User) {
        TODO("Not yet implemented")
    }
}