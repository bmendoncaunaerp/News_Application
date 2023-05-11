package br.unaerp.mynewsapplication

import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET("/v2/everything")
    fun getEverything(): Call<News>
}