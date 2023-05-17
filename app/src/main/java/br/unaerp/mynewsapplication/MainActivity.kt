package br.unaerp.mynewsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var rvArticles: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvArticles = findViewById(R.id.rvArticles)
        rvArticles.layoutManager = LinearLayoutManager(this)

        val newService = ServiceCreator.createNewsService()
        newService.getEverything("brasil").enqueue(NewsCallBack())

    }

    inner class NewsCallBack : Callback<NewsApiResponse> {
        override fun onResponse(call: Call<NewsApiResponse>, response: Response<NewsApiResponse>) {
            Toast.makeText(this@MainActivity, "Deu Certo!", Toast.LENGTH_SHORT).show()
            if(response.isSuccessful) {
                val articleList = response.body()?.articles
                rvArticles.adapter = ArticleAdapter(articleList!!)
            }
        }

        override fun onFailure(call: Call<NewsApiResponse>, t: Throwable) {
            Toast.makeText(this@MainActivity, "Deu Ruim!", Toast.LENGTH_SHORT).show()
            Log.e("Retrofit erro", t.message ?: "Sem mensagem")
        }
    }
}