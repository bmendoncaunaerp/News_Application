package br.unaerp.mynewsapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsService {
    @GET("/v2/everything")
    fun getEverything(
        @Query("q") query: String,
        @Header("X-Api-Key") apiKey: String = "969646ca70794a7b8145a89ed09efa20"
    ): Call<NewsApiResponse>
}