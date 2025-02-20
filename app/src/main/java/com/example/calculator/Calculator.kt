package com.example.calculator

import android.util.Log
import androidx.core.text.isDigitsOnly

const val ADDITION = "+"
const val SUBTRACT = "-"
const val MULTIPLY = "x"   // todo написать все 4 коснатнты в коде
const val DIVIDE = "÷"


class Calculator() {
    private var result: Int = 0
    private var num1: String = ""
    private var num2: String = ""

    private var flag: Boolean = false // в  фолс - 1е число, в тру - 2е
    private var operation: String = ""

    fun getNumber(num: String) {
        if (num == ADDITION) {
            operation = num
            flag = true
        } else if (num == SUBTRACT) {
            operation = num
            flag = true

        } else if (num == MULTIPLY) {
            operation = num
            flag = true
        } else if (num == DIVIDE) {
            operation = num
            flag = true
        }

        else if (num.isDigitsOnly()) {
            if (flag == false) {
                num1 = num1 + num
            } else {
                num2 = num2 + num
            }
        } else if (num == "=") {
            var num1Int = Integer.parseInt(num1)
            var num2Int = Integer.parseInt(num2)
            val a = equal(num1Int, num2Int)

            flag = false
            Log.e("eee", "num1 = $num1")
            Log.e("eee", "num2 = $num2")
            Log.e("eee", a.toString()) // логирование
            result = 0
            num1 = ""
            num2 = ""
        }

    }


    fun add(num1Int: Int, num2Int: Int) {
        result = num1Int + num2Int
    }

    fun subtract(num1Int: Int, num2Int: Int) {
        result = num1Int - num2Int
    }

    fun multiply(num1Int: Int, num2Int: Int) {
        result = num1Int * num2Int
    }

    fun devide(num1Int: Int, num2Int: Int) {
        result = num1Int / num2Int
    }

    fun equal(num1Int: Int, num2Int: Int): Int {
        if (operation == ADDITION) {
            add(num1Int, num2Int)
        } else if (operation == SUBTRACT) {
            subtract(num1Int, num2Int)
        } else if (operation == MULTIPLY) {
            multiply(num1Int, num2Int)
        } else if (operation == DIVIDE) {
            devide(num1Int, num2Int)
        }
        return result
    }

}