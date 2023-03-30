package com.mandiri.core.utils.ext

fun Int?.safe() = this ?: 0

fun String?.safe() = this ?: ""

fun Double?.safe() = this ?: 0.0

fun Long?.safe() = this ?: 0L