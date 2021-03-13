package com.ny.times.ui.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ny.times.R.layout.item_image
import com.ny.times.data.ws.model.mostviewed.MediaMetaData
import kotlinx.android.synthetic.main.item_image.view.*

class MetaDataRecyclerAdapter(private val data : List<MediaMetaData>, activity: Activity?) : BaseRecyclerAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = viewHolder as MyViewHolder
        val model = data[position]
        holder.bind(model,activity)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    init {
        this.activity = activity
    }

    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(item_image, parent, false)) {

        fun bind(entity: MediaMetaData,activity: Activity) {
            entity.url?.let {
                Glide.with(activity)
                    .load(it)
                    .into(itemView.image)
            }
        }

    }
}