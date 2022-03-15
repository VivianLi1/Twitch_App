package com.example.flagquizapp

class MainActivityPresenter(private val view: AppContract.View) : AppContract.Presenter {

    private val quiz = QuizModel(this)

    override fun calculate(x: Int, y: Int) {
        //quiz.calculate(x, y)
    }

    override fun updateCalculation(value: Int) {
        view.calculate(value)
    }

}