package com.igweze.ebi.kotlinmaterialdesign

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var layoutView = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = toolbar as Toolbar
        // set support action bar using toolbar
        // included in activity_main layout
        setSupportActionBar(toolbar)

        // set action bar title and toolbar subtitle
        supportActionBar?.title = "Home Page"
        toolbar.subtitle = "Tasks!!!"
        recyclerView.itemAnimator = DefaultItemAnimator()

        showLandscape()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val message = when (item?.itemId) {
            R.id.discard -> "Discarded"
            R.id.search -> "Searched"
            R.id.edit -> "Edited"
            R.id.settings -> "Settings"
            R.id.exit -> "Exited"
            else -> ""
        } + ": Item Clicked"

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        // show different layout managers
        layoutView = when (item?.itemId) {
            R.id.grid -> "Grid"
            R.id.linearVertical -> "LinearVertical"
            R.id.linearHorizontal -> "LinearHorizontal"
            R.id.staggeredVertical -> "StaggeredGridVertical"
            R.id.staggeredHorizontal -> "StaggeredGridHorizontal"
            else -> ""
        }

        if (layoutView == "" && item?.itemId == R.id.showLandscape) showLandscape()
        else if (layoutView != "" && item?.itemId != R.id.showLandscape) setupRecyclerView()

        return super.onOptionsItemSelected(item)
    }

    private fun setupRecyclerView() {
        // setup recycler view adapter
        val adapter = AnimalRecyclerAdapter(this, Animal.data.toList())
        recyclerView.adapter = adapter

        when(layoutView) {
            "LinearVertical",
            "LinearHorizontal" -> switchToLinear()
            "Grid" -> switchToGrid()
            "StaggeredGridVertical",
            "StaggeredGridHorizontal" -> switchToStaggeredGrid()
            else -> throw IllegalArgumentException("layout view")
        }
    }

    private fun showLandscape() {
        val adapter = LandscapeRecyclerAdapter(this, LandScape.data.toMutableList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun switchToLinear() {
        val orientation = if (layoutView == "LinearVertical") LinearLayoutManager.VERTICAL else LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = LinearLayoutManager(this, orientation, false)
    }

    private fun switchToGrid() {
        val colSpan = 2
        recyclerView.layoutManager = GridLayoutManager(this, colSpan, GridLayoutManager.VERTICAL, false)
    }

    private fun switchToStaggeredGrid() {
        val spanCount = 2
        val orientation = if (layoutView == "StaggeredGridVertical") StaggeredGridLayoutManager.VERTICAL else StaggeredGridLayoutManager.HORIZONTAL
        recyclerView.layoutManager = StaggeredGridLayoutManager(spanCount, orientation)
    }
}