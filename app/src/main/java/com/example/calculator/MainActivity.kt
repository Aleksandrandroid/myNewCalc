package com.example.calculator

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : androidx.activity.ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val calculator: Calculator = Calculator() //объект калькулятор


        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                CalculatorScreen(calculator)
            }
        }
    }



}

@Composable
fun CalculatorScreen(calculator: Calculator) {

    Column(
        modifier = Modifier
            .background(color = Color.DarkGray)
    ) {
        CreateFirstRow("0")

        CreateStandardRow(calculator,
            "AC", color1 = colorResource(R.color.asphalt),
            "+-", color2 = colorResource(R.color.asphalt),
            "%", color3 = colorResource(R.color.asphalt),
            "÷", color4 = colorResource(R.color.orange)
        )

        CreateStandardRow(calculator,
            "7", color1 = colorResource(R.color.greylight),
            "8", color2 = colorResource(R.color.greylight),
            "9", color3 = colorResource(R.color.greylight),
            "х", color4 = colorResource(R.color.orange)
        )

        CreateStandardRow(calculator,
            "4", color1 = colorResource(R.color.greylight),
            "5", color2 = colorResource(R.color.greylight),
            "6", color3 = colorResource(R.color.greylight),
            "-", color4 = colorResource(R.color.orange)
        )

        CreateStandardRow(calculator,
            "1", color1 = colorResource(R.color.greylight),
            "2", color2 = colorResource(R.color.greylight),
            "3", color3 = colorResource(R.color.greylight),
            "+", color4 = colorResource(R.color.orange)
        )

        CreateLastRow(calculator,"0", ",", "=")
    }
}

@Composable
fun CreateText(calculator: Calculator,
    value: String) {
   // Text(text = value, fontSize = 40.sp, color = Color.White)

//    Button(onClick = {                                   //кнопка
//       calculator.getNumber(value)
//    }) {
//        Text(value)
//    }

    FilledTonalButton(onClick = {
        calculator.getNumber(value)
    }) {
        Text(value)
    }

}

@Composable
fun CreateBox(calculator: Calculator,
    value: String, color: Color) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(100.dp)
            .padding(
                start = 1.dp,
                top = 1.dp,
                end = 1.dp,
                bottom = 1.dp
            )
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        CreateText(calculator, value)
    }
}


@Composable
fun CreateBigBox(calculator: Calculator, value: String) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(200.dp)
            .padding(
                start = 2.dp,
                top = 1.dp,
                end = 1.dp,
                bottom = 2.dp
            )
            .background(color = colorResource(R.color.greylight)),
        contentAlignment = Alignment.Center
    ) {
        CreateText(calculator, value)
    }
}

@Composable
fun CreateStandardRow(
    calculator: Calculator,
    value1: String, color1: Color,
    value2: String, color2: Color,
    value3: String, color3: Color,
    value4: String, color4: Color
) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        CreateBox(calculator, value1, color1)
        CreateBox(calculator,  value2, color2)
        CreateBox(calculator, value3, color3)
        CreateBox(calculator, value4, color4)
    }
}


@Composable
fun CreateFirstRow(value: String) {
    Row(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(
                start = 2.dp,
                top = 2.dp,
                end = 2.dp,
                bottom = 1.dp
            )
            .background(color = Color.DarkGray)
    ) {
        FirstBox(value)
    }
}

@Composable
fun CreateLastRow(calculator: Calculator, val1: String, val2: String, val3: String) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        CreateBigBox(calculator, val1)
        CreateBox(calculator,  val2, color = colorResource(R.color.greylight))
        CreateBox(calculator, val3, color = colorResource(R.color.orange))
    }
}

@Composable
fun FirstBox(value: String) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(24.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(text = value, fontSize = 50.sp, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
      //  CalculatorScreen()
    }
}

// @Preview(showBackground = true)
@Composable
fun ShowNewRow(calculator: Calculator) {
    CreateStandardRow(
        calculator,
        value1 = "C", color1 = colorResource(R.color.purple_700),
        value2 = "a", color2 = colorResource(R.color.grass_green),
        value3 = "ш", color3 = colorResource(R.color.purple_700),
        value4 = "a", color4 = colorResource(R.color.teal_700)
    )
}


//@Preview(showBackground = true)
//@Composable
//fun ShowTextLine() {
//    CreateText("Q")
//}


/**
 * Именованные аргументы записывают значения в те переменные, куда по имени их определяют.
 *Если не указать имя, он запишет в первую попавшуюся переменную

 *  Если не указано дефолтное значение при создании функции,  value1, то первое значение 5 запишется
 *  в value1. Если  не написать  value3 = 9, то значение 9 запишется в value2
 *
 *
 */

//fun Qwerty() {
//    wderer(5, value3 = 9)
//    wderer(1, 2, 43535)
//    wderer(123, value3 = 3)
//}
//
//fun wderer(value1: Int, value2: Int = 2, value3: Int) {
//
//}

/** если есть значение при вызове функции, это значение по цепочке можно передать в разные функции,
 * по имени переменноой (как тут value)
 * Значение 345 при вызове в МЭЙН записывается в method1.
 * далее в методе1 вызываем следующий метод 2 и туда передаем значение Value
 * в Методе2  вызываем метод3 и туда передаем значение Value
 * в метод3 записываем метод4 и туда передаем значение Value
 * в методе 4 вызываем метод5 и туда передаем Valie
 * в методе5 выводим значение value
 */

//fun main111() {
//    method1(345)
//}
//
//fun method1(value: Int) {
//    method2(value)
//}
//
//fun method2(value: Int) {
//    method3(value)
//}
//
//fun method3(value: Int) {
//    method4(value)
//}
//
//fun method4(value: Int) {
//    method5(value)
//}
//
//fun method5(value: Int) {
//    println(value)
//}


//
//