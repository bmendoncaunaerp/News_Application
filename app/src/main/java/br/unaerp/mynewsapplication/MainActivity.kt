package br.unaerp.mynewsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newService = ServiceCreator.createNewsService()
        newService.getEverything().enqueue(NewsCallBack())

    }

    inner class NewsCallBack : Callback<News> {
        override fun onResponse(call: Call<News>, response: Response<News>) {
            Toast.makeText(this@MainActivity, "Deu Certo!", Toast.LENGTH_SHORT).show()
            if(response.isSuccessful) {

            }
        }

        override fun onFailure(call: Call<News>, t: Throwable) {
            Toast.makeText(this@MainActivity, "Deu Ruim!", Toast.LENGTH_SHORT).show()
            Log.e("Retrofit erro", t.message ?: "Sem mensagem")
        }
    }
}