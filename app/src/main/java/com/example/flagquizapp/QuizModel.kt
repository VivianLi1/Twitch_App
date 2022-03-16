package com.example.flagquizapp

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.apollographql.apollo3.exception.ApolloException
import com.example.rocketreserver.GetCountriesQuery
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class QuizModel
    (private val quizPresenter: AppContract.QuizPresenter) :
    AppContract.Model{

    private lateinit var answerText: String

    // retrieves Countries names and flags data
    override fun retrieveData() {
        runBlocking {
            launch {
                val response = try {
                    apolloClient.query(GetCountriesQuery()).execute()
                } catch (e: ApolloException) {
                    Log.d("Countries", "Failure", e)
                    null
                }

                quizPresenter.generateQuiz(response?.data?.countries)
                //Log.i("Countries", response?.data?.countries.toString(), null)
            }
        }
    }

    override fun generateQuiz(countries: List<GetCountriesQuery.Country>?) {

        // selects 4 random distinct countries
        val randomCountries = countries?.asSequence()?.shuffled()?.take(4)?.toMutableList()

        // selects 1 to be answer
        val answer = randomCountries?.random()
        answerText = answer?.name ?: ""

        Log.i("Answer", answer!!.name)
        Log.i("Other", randomCountries.toString())

        quizPresenter.updateQuizView(answer, randomCountries)
    }

    override fun submitQuiz(userAnswer: String) {
        quizPresenter.displayFeedback(userAnswer == answerText, answerText)

    }

}