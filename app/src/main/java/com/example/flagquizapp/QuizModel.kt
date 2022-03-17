package com.example.flagquizapp

import android.content.Context
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
    private val SHARED_PREF = "quizScorePref"

    override fun updateScore(context: Context, option: String){
        val sharedPref = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.apply {
            when(option){
                "increase" -> putString("score", (sharedPref.getString("score", "0")?.toInt()?.plus(1)).toString())
                "reset" -> putString("score", "0")
            }

            apply()
        }

        quizPresenter.displayUpdatedScore(sharedPref.getString("score", "0"))
    }

    override fun getScore(context: Context): String?{
        val sharedPref = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        quizPresenter.displayUpdatedScore(sharedPref.getString("score", "0"))

        return sharedPref.getString("score", "0")
    }

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
        if(userAnswer == answerText){
            quizPresenter.updateScore()
        }
    }

}