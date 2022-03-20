package com.example.flagquizapp.presenters

import android.content.Context
import com.example.flagquizapp.AppContract

class MainActivityPresenter(private val view: AppContract.MainView) : AppContract.MainPresenter {

    private val SHARED_PREF = "quizScorePref"

    override fun setLightDarkMode() {
        val sharedPref = view.thisContext().getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        val darkMode = sharedPref.getBoolean("darkMode", false)
        view.setLightDarkMode(darkMode)
    }



}