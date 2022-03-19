package com.example.flagquizapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

open class MainActivity : AppCompatActivity(), AppContract.MainView {

    lateinit var mainPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainActivityPresenter(this)
        mainPresenter.setLightDarkMode()

    }

    override fun onCreateOptionsMenu(menu: Menu) : Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.top_app_bar, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar items
        return when (item.getItemId()) {
            R.id.quizItem -> {
                //composeMessage();
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.right_in, R.anim.left_out)
                Log.d("menu", "quiz")
                true
            }
            R.id.settingsItem -> {
                //showProfileView()
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.left_in, R.anim.right_out)
                Log.d("menu", "settings")
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
    }

    override fun thisContext(): Context {
        return applicationContext
    }

    override fun setLightDarkMode(darkMode: Boolean){
        if(darkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

}