package com.example.flagquizapp.presenters

import com.example.flagquizapp.AppContract
import com.example.flagquizapp.models.SettingsModel

class SettingsPresenter(val view: AppContract.SettingsView): AppContract.SettingsPresenter {

    val settings = SettingsModel(this)

    override fun getScore() {
        settings.getScore(view.thisContext())
    }

    override fun displayScore(score: String?) {
        view.displayScore(score)
    }

    override fun resetScore() {
        settings.resetScore(view.thisContext())
    }

    override fun setDarkMode(darkMode: Boolean) {
        settings.setDarkMode(view.thisContext(), darkMode)
    }

    override fun isPrizeEnabled(requiredScore: Int) {
        settings.isPrizeEnabled(view.thisContext(), requiredScore)
    }

    override fun enablePrize(enable: Boolean) {
        view.enablePrizeButton(enable)
    }
}