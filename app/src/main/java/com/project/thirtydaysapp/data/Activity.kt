package com.project.thirtydaysapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Activity(
    @DrawableRes val imageResourceId: Int,
    @StringRes val day: Int,
    @StringRes val heading: Int,
    @StringRes val content: Int
)
