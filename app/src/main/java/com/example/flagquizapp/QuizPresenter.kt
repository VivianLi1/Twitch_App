package com.example.flagquizapp

import android.content.Context
import android.content.SharedPreferences
import com.example.rocketreserver.GetCountriesQuery

class QuizPresenter(private val view: AppContract.QuizView): AppContract.QuizPresenter{

    private val INCREASE = "increase"
    private val RESET = "reset"

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
        retrieveData()
    }

    override fun displayFeedback(correct: Boolean, answer: String) {
        if (correct) {
            view.displayFeedback("Correct!")
        }else{
            view.displayFeedback("Incorrect! The answer was ${answer}.")
        }
    }

    override fun getScore() {
        quiz.getScore(view.thisContext())
    }

    override fun displayUpdatedScore(score: String?){
        view.updateScore(score)
    }

    override fun incScore(){
        quiz.incScore(view.thisContext())
    }

}