package com.igweze.ebi.kotlinmaterialdesign

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class NavigationFragment: Fragment() {

    lateinit var drawerToggleListener: ActionBarDrawerToggle

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_nav_drawer, container, false)
        val navRecyclerView = view?.findViewById<RecyclerView>(R.id.navRecyclerView)
        navRecyclerView?.adapter = NavigationDrawerAdapter(activity, NavigationDrawerItem.data.toMutableList())
        navRecyclerView?.layoutManager = LinearLayoutManager(activity)
        return view
    }

    fun setupDrawer(fragmentId: Int, drawer: DrawerLayout, toolbar: Toolbar) {
        drawerToggleListener = object: ActionBarDrawerToggle(activity, drawer, toolbar, R.string.open, R.string.close) {
            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
            }

            override fun onDrawerSlide(drawerView: View?, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
            }

            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
            }
        }

        // add a listener to drawer layout interactions
        drawer.addDrawerListener(drawerToggleListener)
        // synchronize the state of drawer toggle
        // on interaction with drawer layout (e.g. on drag drawer menu)
        drawer.post { drawerToggleListener.syncState(); }
    }

}