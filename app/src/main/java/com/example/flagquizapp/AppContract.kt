package com.example.flagquizapp

import android.content.Context
import android.content.SharedPreferences
import com.example.rocketreserver.GetCountriesQuery

interface AppContract {

    interface MainView{
        fun thisContext(): Context
        fun setLightDarkMode(darkMode: Boolean)
    }

    interface QuizView{
        fun updateQuizView(answer: GetCountriesQuery.Country?, countries: MutableList<GetCountriesQuery.Country>?)
        fun displayFeedback(message: String)
        fun updateScore(newScore: String?)
        fun thisContext(): Context
    }

    interface MainPresenter{
        fun setLightDarkMode()
    }

    interface QuizPresenter{
        fun retrieveData()
        fun generateQuiz(countries: List<GetCountriesQuery.Country>?)
        fun updateQuizView(answer: GetCountriesQuery.Country?, countries: MutableList<GetCountriesQuery.Country>?)
        fun submitQuiz(userAnswer: String)
        fun displayFeedback(correct: Boolean, answer: String)
        fun getScore()
        fun displayUpdatedScore(score: String?)
        fun incScore()
    }

    interface QuizModel{
        fun retrieveData()
        fun generateQuiz(countries: List<GetCountriesQuery.Country>?)
        fun submitQuiz(userAnswer: String)
        fun incScore(context: Context)
        fun getScore(context: Context): String?
    }

    interface SettingsPresenter{
        fun displayScore(score: String?)
        fun getScore()
        fun resetScore()
        fun setDarkMode(darkMode: Boolean)
        fun isPrizeEnabled(requiredScore: Int)
        fun enablePrize(enable: Boolean)
    }

    interface SettingsView{
        fun displayScore(newScore: String?)
        fun thisContext(): Context
        fun enablePrizeButton(enable: Boolean)
    }

    interface SettingsModel{
        fun getScore(context: Context)
        fun resetScore(context: Context)
        fun setDarkMode(context: Context, darkMode: Boolean)
        fun isPrizeEnabled(context: Context, requiredScore: Int)
    }
}