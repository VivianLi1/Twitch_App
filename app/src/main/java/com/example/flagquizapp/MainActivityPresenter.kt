package com.example.flagquizapp

import android.content.Context
import com.example.rocketreserver.GetCountriesQuery

class MainActivityPresenter(private val view: AppContract.MainView) : AppContract.MainPresenter {

    private val SHARED_PREF = "quizScorePref"

    override fun setLightDarkMode() {
        val sharedPref = view.thisContext().getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        val darkMode = sharedPref.getBoolean("darkMode", false)
        view.setLightDarkMode(darkMode)
    }



}