package com.example.flagquizapp

import com.example.rocketreserver.GetCountriesQuery

interface AppContract {

    interface MainView{
    }

    interface QuizView{
        fun updateQuizView(answer: GetCountriesQuery.Country?, countries: MutableList<GetCountriesQuery.Country>?)
    }

    interface MainPresenter{
    }

    interface QuizPresenter{
        fun retrieveData()
        fun generateQuiz(countries: List<GetCountriesQuery.Country>?)
        fun updateQuizView(answer: GetCountriesQuery.Country?, countries: MutableList<GetCountriesQuery.Country>?)
        fun submitQuiz(userAnswer: String)
    }

    interface Model{
        fun retrieveData()
        fun generateQuiz(countries: List<GetCountriesQuery.Country>?)
        fun submitQuiz(userAnswer: String)

    }
}