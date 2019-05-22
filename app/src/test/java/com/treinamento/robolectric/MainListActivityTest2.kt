package com.treinamento.robolectric

import android.support.v7.widget.RecyclerView
import android.widget.TextView
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainListActivityTest2 {

    private lateinit var activity: MainListActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(MainListActivity::class.java).setup().get()
    }

    @Test
    fun `Deve preencher a lista com 6 elementos`() {

        val recyclerView = activity.findViewById<RecyclerView>(R.id.recyclerview)

        assertEquals(7, recyclerView.adapter!!.itemCount)
    }

    @Test
    fun `Deve preencher a lista com os textos corretos`() {

        val recyclerView = activity.findViewById<RecyclerView>(R.id.recyclerview)

        val vh0 = recyclerView.findViewHolderForAdapterPosition(0) as MainListActivity.StringViewHolder
        val view0 = vh0.itemView.findViewById<TextView>(R.id.item_title)
        assertEquals("Task 1", view0.text.toString())

    }
}