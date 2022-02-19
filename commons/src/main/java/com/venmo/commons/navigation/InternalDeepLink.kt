package com.venmo.commons.navigation

import androidx.core.net.toUri

/**
 * Deep link are great if we don't use complex values such as serializable/parcelable models
 */
object InternalDeepLink {
    private const val DOMAIN = "venmo://"

    fun goToProfile() = "${DOMAIN}profile".toUri()

    fun goToCreditCard(user: String) = "${DOMAIN}credit_card?userId=${user}".toUri()
}