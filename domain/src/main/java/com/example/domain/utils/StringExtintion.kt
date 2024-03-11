package com.example.domain.utils

import android.util.Patterns

fun String.isValidEmail(): Boolean {
    val emailRegex = "^[\\w.-]+@[\\w.-]+\\.\\w{2,4}$"
    return this.matches(emailRegex.toRegex())
}

fun String.capitalizeWords(): String = split(" ").joinToString(" ") { it.capitalize() }

fun String.isNumeric(): Boolean = toIntOrNull() != null

fun String.toTitleCase(): String = this.split(" ").joinToString(" ") { it.capitalize() }

fun String.isAlphabetic(): Boolean = all { it.isLetter() }

fun String.isValidUrl(): Boolean {
    val pattern = Patterns.WEB_URL
    return pattern.matcher(this).matches()
}

fun String.maskEmail(): String {
    val atIndex = indexOf("@")
    if (atIndex <= 1) return this
    return "${this[0]}***${this[atIndex - 1]}${substring(atIndex)}"
}

fun String.csvToList(): List<String> = this.split(",").map { it.trim() }


fun String.extractDigits(): String = filter { it.isDigit() }


fun String.limitLength(maxLength: Int): String = if (this.length <= maxLength) this else this.take(maxLength) + "..."
