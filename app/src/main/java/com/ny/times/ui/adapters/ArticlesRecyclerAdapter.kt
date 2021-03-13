package com.ny.times.ui.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ny.times.R.layout.item_article
import com.ny.times.data.ws.model.mostviewed.ResultModel
import kotlinx.android.synthetic.main.fragment_article_detail.view.*
import java.util.*

class ArticlesRecyclerAdapter(private val results: ArrayList<ResultModel>, activity: Activity?,
                              private val listener: ArticleClickListener) : BaseRecyclerAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = viewHolder as MyViewHolder
        val model = results[position]
        holder.bind(model,listener)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    init {
        this.activity = activity
    }

    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(item_article, parent, false)) {

        fun bind(entity: ResultModel,listener: ArticleClickListener) {
            itemView.title_txt.text = entity.title
            itemView.byline_txt.text = entity.byline
            itemView.section_txt.text = entity.section
            entity.published_date?.let {
                itemView.date_txt.text = entity.published_date
            }

            itemView.setOnClickListener {
                listener.onArticleClick(itemView,entity)
            }
        }

    }
}