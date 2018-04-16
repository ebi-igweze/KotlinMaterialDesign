package com.igweze.ebi.kotlinmaterialdesign

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class RecyclerAdapter(val ctx: Context, val data: List<LandScape>):  RecyclerView.Adapter<RecyclerAdapter.LandscapeViewHolder>() {

    private val inflater = LayoutInflater.from(ctx)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LandscapeViewHolder {
        val listItem = inflater.inflate(R.layout.list_item, parent, false)
        return LandscapeViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: LandscapeViewHolder?, position: Int) {
        val landscape = data[position]
        holder?.setData(landscape, position)
    }

    override fun getItemCount(): Int = data.size

    class LandscapeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.imgTitle)
        val image: ImageView = view.findViewById(R.id.imgRow)
        val iconAdd: ImageView = view.findViewById(R.id.iconAdd)
        val iconDelete: ImageView = view.findViewById(R.id.iconDelete)
        val description: TextView = view.findViewById(R.id.imgDescription)
        var itemPosition = 0
        lateinit var current: LandScape

        fun setData(item: LandScape, position: Int) {
            current = item
            itemPosition = position
            title.text = item.title
            description.text = item.description
            image.setImageResource(item.imageSrc)
        }
    }
}