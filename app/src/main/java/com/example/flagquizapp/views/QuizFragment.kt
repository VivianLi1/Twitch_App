package com.example.flagquizapp.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.flagquizapp.AppContract
import com.example.flagquizapp.presenters.QuizPresenter
import com.example.flagquizapp.R
import com.example.rocketreserver.GetCountriesQuery
import com.google.android.material.snackbar.Snackbar

class QuizFragment : Fragment(), AppContract.QuizView {


    private lateinit var mView: View
    private lateinit var quizPresenter: AppContract.QuizPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        quizPresenter = QuizPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_quiz, container, false)
        mView = view

        // retrieves countries data
        quizPresenter.retrieveData()
        // retrieves quiz score
        quizPresenter.getScore()

        val button1 = mView.findViewById<Button>(R.id.option1)
        val button2 = mView.findViewById<Button>(R.id.option2)
        val button3 = mView.findViewById<Button>(R.id.option3)
        val button4 = mView.findViewById<Button>(R.id.option4)

        button1.setOnClickListener {
            quizPresenter.submitQuiz(button1.text as String)
        }
        button2.setOnClickListener {
            quizPresenter.submitQuiz(button2.text as String)
        }
        button3.setOnClickListener {
            quizPresenter.submitQuiz(button3.text as String)
        }
        button4.setOnClickListener {
            quizPresenter.submitQuiz(button4.text as String)
        }

        return view
    }

    override fun updateQuizView(
        answer: GetCountriesQuery.Country?,
        countries: MutableList<GetCountriesQuery.Country>?
    ) {
        // set flag texview to country's flag emoji
        val flagText = mView.findViewById<TextView>(R.id.flagEmoji)
        flagText.text = answer?.emoji

        // get list of option buttons
        val buttonList = listOf<Button>(
            mView.findViewById(R.id.option1),
            mView.findViewById(R.id.option2),
            mView.findViewById(R.id.option3),
            mView.findViewById(R.id.option4))

        // randomly assign country names to buttons
        for(i in 1..4) {
            val randomCountry = countries?.random()
            countries?.removeIf{c -> c == randomCountry}

            buttonList[i-1].text = randomCountry?.name
        }
    }

    override fun displayFeedback(message: String) {
        Snackbar.make(mView, message, Snackbar.LENGTH_SHORT)
            .show()
    }

    override fun updateScore(newScore: String?) {
        val score = mView.findViewById<TextView>(R.id.score)
        score.text = newScore
    }

    override fun thisContext(): Context {
        return super.requireContext()
    }
}