package com.example.flagquizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.rocketreserver.GetCountriesQuery

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFragment : Fragment(), AppContract.QuizView {
    // TODO: Rename and change types of parameters

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


}