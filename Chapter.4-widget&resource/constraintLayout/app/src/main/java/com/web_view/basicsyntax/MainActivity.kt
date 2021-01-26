package com.web_view.basicsyntax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var squareResult = square(30)
        Log.d("fun", "30의 제곱은 ${squareResult}입니다.")

        printSum(3,5)

        val PI = getPi()
        Log.d("fun", "원의 둘레: ${PI}")

        newFunction("Hello")
        newFunction("my", weight = 65.5)
    }
    fun square(x: Int) : Int{
        return x*x
    }

    fun printSum(x: Int, y: Int){
        Log.d("fun", "x + y = ${x + y}")
    }

    fun getPi() : Double{
        return 3.14
    }
    fun newFunction(name: String, age: Int = 29, weight: Double = 65.5){
        Log.d("fun", "name은 ${name}입니다.")
        Log.d("fun", "age은 ${age}입니다.")
        Log.d("fun", "weight은 ${weight}입니다.")
    }
}