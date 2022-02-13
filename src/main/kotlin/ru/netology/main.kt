package ru.netology

const val MINUTE = 60
const val HOUR = 3600
const val DAY = 86400

fun main() {

    println("был(а) ${agoToText(1111)}")
}

fun agoToText(countSeconds: Int): String {

    return when {
        (countSeconds <= MINUTE) -> "только что"
        (countSeconds < HOUR) -> "${TimeToText(countSeconds, MINUTE, "минуту", "минуты", "минут")} назад"
        (countSeconds < DAY) -> "${TimeToText(countSeconds, HOUR, "час", "часа", "часов")} назад"
        (countSeconds < DAY*2) -> "сегодня"
        (countSeconds < DAY*3) -> "вчера"
        else -> "давно"
    }

}

fun TimeToText(countSeconds: Int, secondInUnit: Int,
                  representation1: String, representation2: String, representation3: String): String {

    val countUnits: Int = countSeconds / secondInUnit;

    return when {
        (countUnits % 10 == 1 && (countUnits % 100) != 11) -> countUnits.toString() + " " + representation1
        ((countUnits % 10 == 2 || countUnits % 10 == 3 || countUnits % 10 == 4) && countUnits/10 != 1) -> countUnits.toString() + " " + representation2
        else -> countUnits.toString() + " " + representation3
    }

}



