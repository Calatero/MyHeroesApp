package com.example.myheroeapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myheroeapp.R
import com.example.myheroeapp.models.Publisher
import com.squareup.picasso.Picasso

class PublisherAdapter(val publisherList: List<Publisher>, val onClick: (Publisher) -> Unit): RecyclerView.Adapter<PublisherViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublisherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.publisher_item,parent,false)
        return PublisherViewHolder(view)
    }

    override fun getItemCount(): Int {
        return publisherList.count()
    }

    override fun onBindViewHolder(holder: PublisherViewHolder, position: Int) {
        val publisher = publisherList[position]
        Picasso.get().load(publisher.img).into(holder.publisherImage)

        holder.itemView.setOnClickListener{
            Log.i("Editora", publisher.name)
            onClick(publisher)
        }
    }

}

class PublisherViewHolder(view: View): ViewHolder(view)
{
    val publisherImage: ImageView = view.findViewById(R.id.publisherImage)
}