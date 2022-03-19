package com.example.flagquizapp

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
}