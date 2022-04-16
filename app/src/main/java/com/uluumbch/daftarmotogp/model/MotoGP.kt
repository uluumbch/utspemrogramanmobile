package com.uluumbch.daftarmotogp.model

import androidx.annotation.DrawableRes
import java.io.Serializable

data class MotoGP(
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val countryIcon: Int,
    val stringName: String,
    val bike: String,
    val DOB: String,
    val height: String,
    val weight: String,
    val info: String
) : Serializable