package com.ny.times.ui.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ny.times.R.layout.item_media
import com.ny.times.data.ws.model.mostviewed.MediaModel
import kotlinx.android.synthetic.main.item_media.view.*

class MediaRecyclerAdapter(private val mediaList : List<MediaModel>, activity: Activity?) : BaseRecyclerAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = viewHolder as MyViewHolder
        val model = mediaList[position]
        holder.bind(model,activity)
    }

    override fun getItemCount(): Int {
        return mediaList.size
    }

    init {
        this.activity = activity
    }

    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(item_media, parent, false)) {

        fun bind(entity: MediaModel,activity:Activity) {
            itemView.caption_txt.text = entity.caption
            itemView.copy_right_txt.text = entity.copyright
            entity.mediaMetaData?.let {
                itemView.images_recycler.adapter = MetaDataRecyclerAdapter(it,activity)
            }
        }

    }
}