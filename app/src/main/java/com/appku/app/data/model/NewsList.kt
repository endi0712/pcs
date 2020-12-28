package com.appku.app.data.model

data class NewsList(
    val results: List<News> = arrayListOf(),
    val method: String="",
    val status: Boolean=false
)
