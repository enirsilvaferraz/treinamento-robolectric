package com.treinamento.robolectric

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main_list.*

class MainListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = CustomAdapter()
    }

    class CustomAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        private val list = arrayListOf("Task 1", "Task 2", "Task 3", "Task 4", "Task 5", "Task 6", "Task 7")

        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
            return StringViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
        }

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(vh: RecyclerView.ViewHolder, p1: Int) {
            (vh as StringViewHolder).bind(list[p1])
        }

    }

    class StringViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(text: String) {
            itemView.findViewById<TextView>(R.id.item_title).text = text
        }
    }


}
