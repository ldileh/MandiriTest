package com.mandiri.test.ui.model

import androidx.annotation.Keep
import com.mandiri.test.domain.remote.model.Genre

@Keep
data class GenreModel(
    val data: Genre,
    var isSelected: Boolean = false
)

fun List<Genre>.translate(): List<GenreModel> = map { GenreModel(it) }