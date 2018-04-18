package com.igweze.ebi.kotlinmaterialdesign

import java.lang.Thread.yield
import kotlin.coroutines.experimental.buildSequence

data class LandScape(val id: Int, val title: String, val description: String, val imageSrc: Int) {

    companion object {
        private val images = arrayOf(
                R.drawable.thumb_1_0, R.drawable.thumb_1_1,
                R.drawable.thumb_1_2, R.drawable.thumb_1_3,
                R.drawable.thumb_1_4, R.drawable.thumb_1_5,
                R.drawable.thumb_1_6, R.drawable.thumb_1_7,
                R.drawable.thumb_1_2, R.drawable.thumb_1_9,
                R.drawable.thumb_2_0, R.drawable.thumb_2_1)

        val data = buildSequence {
            for (i in 0 until images.size) {
                val title = "Landscape $i"
                val description = "Some description for landscape $i"
                val item = LandScape(i, title, description,  images[i])
                yield(item)
            }
        }
    }
}

data class Animal(val id: Int, val title: String, val description: String, val imageSrc: Int) {

    companion object {
        private val images = arrayOf(
                R.drawable.ani_cat_one, R.drawable.ani_cat_two,
                R.drawable.ani_cat_three, R.drawable.ani_cat_four,
                R.drawable.ani_cat_five, R.drawable.ani_cat_six,
                R.drawable.ani_cat_seven, R.drawable.ani_deer_one,
                R.drawable.ani_deer_two, R.drawable.ani_deer_three,
                R.drawable.ani_deer_four)

        val data = buildSequence {
            for (i in 0 until images.size) {
                val title = "Landscape $i"
                val description = "Some description for animal $i"
                val item = Animal(i, title, description,  images[i])
                yield(item)
            }
        }
    }
}