package com.example.flagquizapp

import com.example.rocketreserver.GetCountriesQuery

interface AppContract {

    interface View{
        fun calculate(value: Int)
    }

    interface QuizView{
        fun updateQuizView(answer: GetCountriesQuery.Country?, countries: MutableList<GetCountriesQuery.Country>?)
    }

    interface MainPresenter{
        fun calculate(x: Int, y: Int)
        fun updateCalculation(value: Int)
    }

    interface QuizPresenter{
        fun retrieveData()
        fun generateQuiz(countries: List<GetCountriesQuery.Country>?)
        fun updateQuizView(answer: GetCountriesQuery.Country?, countries: MutableList<GetCountriesQuery.Country>?)
    }

    interface Model{
        fun retrieveData()
        fun generateQuiz(countries: List<GetCountriesQuery.Country>?)
    }
}