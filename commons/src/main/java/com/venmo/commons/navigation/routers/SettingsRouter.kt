package com.venmo.commons.navigation.routers

import android.app.Activity
import androidx.fragment.app.FragmentManager

interface SettingsRouter {
    fun navigate(activity: Activity)
    fun navigate(fragmentManager: FragmentManager)
}