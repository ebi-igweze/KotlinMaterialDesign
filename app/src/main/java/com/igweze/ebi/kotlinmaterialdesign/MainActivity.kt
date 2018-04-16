package com.igweze.ebi.kotlinmaterialdesign

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = recyclerView
        val adapter = RecyclerAdapter(this, LandScape.data.toList())
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
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
            R.id.grid -> "Switch to Grid"
            else -> ""
        } + ": Item Clicked"

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        return super.onOptionsItemSelected(item)
    }
}
