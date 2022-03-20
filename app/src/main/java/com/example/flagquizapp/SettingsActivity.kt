package com.example.flagquizapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SettingsActivity : MainActivity(), AppContract.SettingsView {

    lateinit var settingsPresenter: SettingsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        settingsPresenter = SettingsPresenter(this)
        settingsPresenter.getScore()

        val resetButton = findViewById<Button>(R.id.resetButton)
        resetButton.setOnClickListener {
            confirmResetDialog()
        }

        val lightDarkToggle = findViewById<Switch>(R.id.lightDarkToggle)

        lightDarkToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                settingsPresenter.setDarkMode(true)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                settingsPresenter.setDarkMode(false)
            }
        }
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

    fun confirmResetDialog(){
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.reset_dialog_title)
            .setNeutralButton(resources.getString(R.string.cancel)){dialog, which ->

            }
            .setPositiveButton(resources.getString(R.string.confirm)){dialog, which ->
                settingsPresenter.resetScore()
            }
            .show()
    }
}