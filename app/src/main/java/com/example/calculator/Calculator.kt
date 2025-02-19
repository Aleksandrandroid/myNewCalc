package com.example.calculator

import android.util.Log
import androidx.core.text.isDigitsOnly

class Calculator() {
    private var result: Int = 0
    private var num1: Int = 0
    private var num2: Int = 0
    private var flag: Boolean = false // в  фолс - 1е число, в тру - 2е
    private var operation: String = ""

    fun getNumber(num: String) {
        if (num == "+") {
            operation = num
            flag = true
        } else if (num == "-") {
            operation = num
            flag = true

        } else if (num == "*") {
            operation = num
            flag = true
        }

        else if (num.isDigitsOnly()) {

            if (flag == false) {
                num1 = Integer.parseInt(num)
            } else {
                num2 = Integer.parseInt(num)
            }


        } else if (num == "=") {
            val a = equal()
            flag = false
            Log.e("eee", a.toString())    // логирование
        }

    }


    fun add() {
        result = num1 + num2
    }

    fun subract() {
        result = num1 - num2
    }

    fun multiply() {
        result = num1 * num2
    }

    fun devide() {
        result = num1 / num2
    }

    fun equal(): Int {
        if (operation == "+") {
            add()
        } else if (operation == "-") {
            subract()
        } else if (operation == "*") {
            multiply()
        } else if (operation == "/"){
            devide()
        }
        return result
    }

}