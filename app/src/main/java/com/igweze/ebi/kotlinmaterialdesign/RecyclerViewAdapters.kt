package com.igweze.ebi.kotlinmaterialdesign

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class LandscapeRecyclerAdapter(ctx: Context, val data: List<LandScape>):  RecyclerView.Adapter<LandscapeRecyclerAdapter.LandscapeViewHolder>() {

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

        private val title: TextView = view.findViewById(R.id.imgTitle)
        private val image: ImageView = view.findViewById(R.id.imgRow)
//        private val iconAdd: ImageView = view.findViewById(R.id.iconAdd)
//        private val iconDelete: ImageView = view.findViewById(R.id.iconDelete)
        private val description: TextView = view.findViewById(R.id.imgDescription)
        private var itemPosition = 0
        private lateinit var current: LandScape

        fun setData(item: LandScape, position: Int) {
            current = item
            itemPosition = position
            title.text = item.title
            description.text = item.description
            image.setImageResource(item.imageSrc)
        }
    }
}

class AnimalRecyclerAdapter(ctx: Context, val data: List<Animal>):  RecyclerView.Adapter<AnimalRecyclerAdapter.AnimalViewHolder>() {

    private val inflater = LayoutInflater.from(ctx)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AnimalViewHolder {
        val listItem = inflater.inflate(R.layout.animal_list_item, parent, false)
        return AnimalViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder?, position: Int) {
        val animal = data[position]
        holder?.setData(animal, position)
    }

    override fun getItemCount(): Int = data.size

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = view.findViewById(R.id.imgTitle)
        private val image: ImageView = view.findViewById(R.id.imgRow)
        private val description: TextView = view.findViewById(R.id.imgDescription)
        private var itemPosition = 0
        private lateinit var current: Animal

        fun setData(item: Animal, position: Int) {
            current = item
            itemPosition = position
            title.text = item.title
            description.text = item.description
            image.setImageResource(item.imageSrc)
        }
    }
}