package com.example.flagquizapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.TextView

class SettingsActivity : MainActivity(), AppContract.SettingsView {

    lateinit var settingsPresenter: SettingsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        settingsPresenter = SettingsPresenter(this)
        settingsPresenter.getScore()
    }

    // displays score on view
    override fun displayScore(newScore: String?) {
        val score = findViewById<TextView>(R.id.score2)
        score.text = newScore
    }

    // returns context of current activity
    override fun thisContext(): Context {
        return applicationContext
    }


}