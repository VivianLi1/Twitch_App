package com.example.flagquizapp

import com.example.rocketreserver.GetCountriesQuery

class MainActivityPresenter(private val view: AppContract.View) : AppContract.MainPresenter {

    override fun calculate(x: Int, y: Int) {
        //quiz.calculate(x, y)
    }

    override fun updateCalculation(value: Int) {
        view.calculate(value)
    }

}