package com.venmo.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    var id: String,
    var name: String
): Parcelable
