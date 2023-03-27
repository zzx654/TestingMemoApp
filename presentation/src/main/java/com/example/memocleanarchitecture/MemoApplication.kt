package com.example.memocleanarchitecture

import android.app.Application
import com.example.memocleanarchitecture.ui.theme.*
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MemoApplication: Application() {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}