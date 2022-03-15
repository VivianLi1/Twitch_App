package com.example.flagquizapp

interface AppContract {

    interface View{
        fun calculate(value: Int)
    }

    interface Presenter{
        fun calculate(x: Int, y: Int)
        fun updateCalculation(value: Int)
        fun retrieveData()
    }

    interface Model{
        fun retrieveData()
    }
}