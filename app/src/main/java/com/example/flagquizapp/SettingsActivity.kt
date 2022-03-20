package com.example.flagquizapp

import android.content.Context
import android.content.Intent
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

        //initialize presenter
        settingsPresenter = SettingsPresenter(this)

        //add listener to reset score button
        val resetButton = findViewById<Button>(R.id.resetButton)
        resetButton.setOnClickListener {
            confirmResetDialog()
        }

        val lightDarkToggle = findViewById<Switch>(R.id.lightDarkToggle)

        // if light dark toggle enable, set dark mode
        lightDarkToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                settingsPresenter.setDarkMode(true)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                settingsPresenter.setDarkMode(false)
            }
        }

        //set prize button listener -> go to prize activity
        val prizeButton = findViewById<Button>(R.id.prizeButton)
        prizeButton.isEnabled = false
        prizeButton.setOnClickListener {
            val intent = Intent(this, PrizeActivity::class.java)
            startActivity(intent)
        }

        settingsPresenter.getScore()
        settingsPresenter.isPrizeEnabled(10)
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

    // dialog to confirm score reset
    private fun confirmResetDialog(){
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.reset_dialog_title)
            .setNeutralButton(resources.getString(R.string.cancel)){_, _ ->

            }
            .setPositiveButton(resources.getString(R.string.confirm)){_, _ ->
                settingsPresenter.resetScore()
            }
            .show()
    }

    override fun enablePrizeButton(enable: Boolean){
        val prizeButton = findViewById<Button>(R.id.prizeButton)
        prizeButton.isEnabled = enable
    }
}