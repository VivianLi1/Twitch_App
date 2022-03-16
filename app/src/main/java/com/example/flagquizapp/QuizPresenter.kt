package com.example.flagquizapp

import com.example.rocketreserver.GetCountriesQuery

class QuizPresenter(private val view: AppContract.QuizView): AppContract.QuizPresenter {

    private val quiz = QuizModel(this)

    override fun retrieveData() {
        quiz.retrieveData()
    }

    override fun generateQuiz(countries: List<GetCountriesQuery.Country>?) {
        quiz.generateQuiz(countries)
    }

    override fun updateQuizView(
        answer: GetCountriesQuery.Country?,
        countries: MutableList<GetCountriesQuery.Country>?
    ) {
        view.updateQuizView(answer, countries)
    }

    override fun submitQuiz(userAnswer: String) {
        quiz.submitQuiz(userAnswer)
    }


}