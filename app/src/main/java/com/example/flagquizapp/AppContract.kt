package com.example.flagquizapp

import android.content.Context
import android.content.SharedPreferences
import com.example.rocketreserver.GetCountriesQuery

interface AppContract {

    interface MainView{
    }

    interface QuizView{
        fun updateQuizView(answer: GetCountriesQuery.Country?, countries: MutableList<GetCountriesQuery.Country>?)
        fun displayFeedback(message: String)
        fun updateScore(newScore: String?)
        fun thisContext(): Context
    }

    interface MainPresenter{
    }

    interface QuizPresenter{
        fun retrieveData()
        fun generateQuiz(countries: List<GetCountriesQuery.Country>?)
        fun updateQuizView(answer: GetCountriesQuery.Country?, countries: MutableList<GetCountriesQuery.Country>?)
        fun submitQuiz(userAnswer: String)
        fun displayFeedback(correct: Boolean, answer: String)
        fun getScore()
        fun displayUpdatedScore(score: String?)
        fun updateScore()
    }

    interface Model{
        fun retrieveData()
        fun generateQuiz(countries: List<GetCountriesQuery.Country>?)
        fun submitQuiz(userAnswer: String)
        fun updateScore(context: Context, option: String)
        fun getScore(context: Context): String?
    }
}