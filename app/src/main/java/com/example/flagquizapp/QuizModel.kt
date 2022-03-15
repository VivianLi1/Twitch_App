package com.example.flagquizapp

import android.util.Log
import com.apollographql.apollo3.exception.ApolloException
import com.example.rocketreserver.GetCountriesQuery
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class QuizModel(private val presenter: AppContract.Presenter): AppContract.Model{

    /*
    override fun calculate(x: Int, y: Int) {
        presenter.updateCalculation(x + y)
    }

     */

    override fun retrieveData() {
        Log.d("here", "is here")
        runBlocking {
            launch {
                val response = try {
                    apolloClient.query(GetCountriesQuery()).execute()
                } catch (e: ApolloException) {
                    Log.d("Countries", "Failure", e)
                    null
                }


                Log.i("Countries", response?.data?.toString(), null)
            }
        }
    }

}