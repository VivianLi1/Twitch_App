package com.example.flagquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity(), AppContract.MainView {

    //private lateinit var quizPresenter: AppContract.QuizPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //quizPresenter = QuizPresenter(this)

        // retrieves countries data
        //quizPresenter.retrieveData()
    }

}