package com.mandiri.test.util.extenstion

import com.google.gson.JsonObject

fun JsonObject?.getErrorMessage(defMessage: String) =
    this?.get("status_message")?.asString ?: defMessage

fun getImageUrl(path: String?) = "https://image.tmdb.org/t/p/original/$path"