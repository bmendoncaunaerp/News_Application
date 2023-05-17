package br.unaerp.mynewsapplication

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("title")
    val title: String,
    @SerializedName("author")
    val author: String?,
    @SerializedName("description")
    val description: String
)
