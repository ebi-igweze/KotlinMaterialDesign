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