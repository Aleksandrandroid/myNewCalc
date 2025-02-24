package com.example.calculator

import android.util.Log
import androidx.core.text.isDigitsOnly
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

const val ADDITION = "+"
const val SUBTRACT = "-"
const val MULTIPLY = "x"
const val DIVIDE = "÷"
const val AC = "AC"
const val EQUALS = "="

class Calculator() {
    private var result: Int = 0
    private var num1: String = ""
    private var num2: String = ""
    private var flag: Boolean = false // в  фолс - 1е число, в тру - 2е
    private var operation: String = ""
    private val _result1 =
        MutableStateFlow(  "")   //переменная использоуется только в тоом классе, где она написана.
    val result1 = _result1.asStateFlow()   // result1 - переменная вытаскивает наружу класса


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
        } else if (num == AC) {
            delete()
        } else if (num.isDigitsOnly()) {
            if (flag == false) {
                num1 = num1 + num
            } else {
                num2 = num2 + num
            }
        } else if (num == EQUALS) {
            try {
                var num1Int = Integer.parseInt(num1)
                var num2Int = Integer.parseInt(num2)
                val a = equal(num1Int, num2Int)
                _result1.value = a.toString()

                Log.e("eee", "num1 = $num1")
                Log.e("eee", "num2 = $num2")
                Log.e("eee", a.toString()) // логирование
            } catch (error: NumberFormatException) {
                Log.e("eee", "Ошибка произошла")
            } catch (error: ArithmeticException) {
                Log.e("eee", "Деление на ноль - не определеноо")
                _result1.value = "Не определено"
            }
            delete()
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

    fun delete() {
        flag = false
        result = 0
        num1 = ""
        num2 = ""
        operation = ""
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