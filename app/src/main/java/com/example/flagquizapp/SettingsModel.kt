package com.example.flagquizapp

import android.content.Context
import android.util.Log

class SettingsModel(val settingsPresenter: SettingsPresenter): AppContract.SettingsModel {

    private val SHARED_PREF = "quizScorePref"

    override fun getScore(context: Context) {
        val sharedPref = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        //Log.i("score", sharedPref.getString("score", "0") ?: "no score")
        settingsPresenter.displayScore(sharedPref.getString("score", "0"))

        //return sharedPref.getString("score", "0")
    }

    override fun resetScore(context: Context) {
        val sharedPref = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.apply {
            putString("score", "0")
            apply()
        }

        settingsPresenter.displayScore(sharedPref.getString("score", "0"))
        settingsPresenter.enablePrize(false)
    }

    override fun setDarkMode(context: Context, darkMode: Boolean) {
        val sharedPref = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.apply {
            putBoolean("darkMode", darkMode)
            apply()
        }
    }

    override fun isPrizeEnabled(context: Context, requiredScore: Int) {
        val sharedPref = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        val score = sharedPref.getString("score", "0")?.toInt()

        val enable = score?.compareTo(requiredScore) ?: 0 >= 0

        Log.d("scoreGreater", enable.toString())

        settingsPresenter.enablePrize(enable)
    }
}