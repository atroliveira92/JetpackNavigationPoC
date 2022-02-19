package com.venmo.features.router

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.FragmentManager
import com.venmo.commons.navigation.routers.SettingsRouter
import com.venmo.features.settings.SettingsActivity
import com.venmo.features.settings.SettingsDialogFragment

class SettingsRouterImpl: SettingsRouter {
    override fun navigate(activity: Activity) {
        activity.startActivity(Intent(activity, SettingsActivity::class.java))
    }

    override fun navigate(fragmentManager: FragmentManager) {
        SettingsDialogFragment().show(fragmentManager, "settings_dialog")
    }
}