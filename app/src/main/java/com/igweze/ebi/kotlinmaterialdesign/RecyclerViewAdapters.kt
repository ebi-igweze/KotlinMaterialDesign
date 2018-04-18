package com.igweze.ebi.kotlinmaterialdesign

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class LandscapeRecyclerAdapter(ctx: Context, val data: MutableList<LandScape>):  RecyclerView.Adapter<LandscapeRecyclerAdapter.LandscapeViewHolder>() {

    private val inflater = LayoutInflater.from(ctx)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LandscapeViewHolder {
        val layout = inflater.inflate(R.layout.list_item, parent, false)
        return LandscapeViewHolder(layout)
    }

    override fun onBindViewHolder(holder: LandscapeViewHolder?, position: Int) {
        val landscape = data[position]
        holder?.setData(landscape, position)
        holder?.setListeners()
    }

    override fun getItemCount(): Int = data.size

    fun addItem(position: Int, landscape: LandScape) {
        data.add(position,landscape)
        notifyItemInserted(position)
        notifyItemRangeChanged(position, data.size)
    }

    fun removeItem(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, data.size)
    }

    inner class LandscapeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = view.findViewById(R.id.imgTitle)
        private val image: ImageView = view.findViewById(R.id.imgRow)
        private val iconAdd: ImageView = view.findViewById(R.id.iconAdd)
        private val iconDelete: ImageView = view.findViewById(R.id.iconDelete)
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

        fun setListeners() {
            iconAdd.setOnClickListener {
                addItem(itemPosition, current)
            }
            iconDelete.setOnClickListener {
                removeItem(itemPosition)
            }
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

class ConditionalRecyclerAdapter(ctx: Context, val data: MutableList<LandScape>):  RecyclerView.Adapter<ConditionalRecyclerAdapter.LandscapeViewHolder>() {
    companion object {
        private const val PRIME = 0
        private const val NON_PRIME = 1
    }

    private val inflater = LayoutInflater.from(ctx)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LandscapeViewHolder {
        val listItem = when(viewType) {
            PRIME -> R.layout.list_item_prime
            else -> R.layout.list_item_not_prime
        }

        val layout = inflater.inflate(listItem, parent, false)
        return LandscapeViewHolder(layout)
    }

    override fun onBindViewHolder(holder: LandscapeViewHolder?, position: Int) {
        val landscape = data[position]
        holder?.setData(landscape)
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int = if (data[position].isPrime) PRIME else NON_PRIME

    inner class LandscapeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = view.findViewById(R.id.imgTitle)
        private val image: ImageView = view.findViewById(R.id.imgRow)
        private val iconType: ImageView = view.findViewById(R.id.iconType)
        private val description: TextView = view.findViewById(R.id.imgDescription)
        private lateinit var current: LandScape

        fun setData(item: LandScape) {
            current = item
            title.text = item.title
            description.text = item.description
            image.setImageResource(item.imageSrc)
            val resource = if (item.isPrime) R.drawable.prime else R.drawable.not_prime
            iconType.setImageResource(resource)
        }

    }
}

class NavigationDrawerAdapter(val ctx: Context, val data: MutableList<NavigationDrawerItem>): RecyclerView.Adapter<NavigationDrawerAdapter.ItemViewHolder>() {

    val inflater = LayoutInflater.from(ctx)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        val view = inflater.inflate(R.layout.nav_drawer_list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        val item = data[position];
        holder?.setData(item)
    }


    inner class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        private val imgIcon = view.findViewById<ImageView>(R.id.navIcon)
        private val imgTitle = view.findViewById<TextView>(R.id.navTitle)

        fun setData(item: NavigationDrawerItem) {
            imgIcon.setImageResource(item.imageSrc)
            imgTitle.text = item.title
            view.setOnClickListener{
                Toast.makeText(ctx, item.title, Toast.LENGTH_LONG).show();
            }
        }

    }
}