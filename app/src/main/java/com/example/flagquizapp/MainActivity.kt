package com.example.flagquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity(), AppContract.View {

    private lateinit var presenter: AppContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this)

        //presenter.calculate(5, 6)
        presenter.retrieveData()
    }

    override fun calculate(value: Int) {
        //Toast.makeText(this, value.toString(), Toast.LENGTH_SHORT).show()
    }
}