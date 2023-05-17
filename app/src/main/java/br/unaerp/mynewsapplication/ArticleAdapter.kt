package br.unaerp.mynewsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticleAdapter(
    val articles: List<News>
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>()  {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            val title: TextView = itemView.findViewById(R.id.title)
            val author: TextView = itemView.findViewById(R.id.author)
            val description: TextView = itemView.findViewById(R.id.description)

            title.text = articles[position].title
            author.text = articles[position].author
            description.text = articles[position].description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_item, parent, false)

        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int  = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(position)
    }
}