package com.teamwork.josehidalgo.extensions

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}

fun String.toDate(dateFormat: Int = DateFormat.MEDIUM): Date {
    val formatIn = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    return formatIn.parse(this)
}

fun Date.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val formatOut = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return formatOut.format(this)
}