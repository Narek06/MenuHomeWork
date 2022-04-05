package com.example.menuhomework

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity2 : AppCompatActivity() {
    lateinit var adapter2: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val recyclerView2 = findViewById<RecyclerView>(R.id.my_rec_view2)
        val total_price = findViewById<TextView>(R.id.totalPrice_text)
        total_price.text = FavoriteList.totalPrice.toString() + " դ."

        adapter2 = MainAdapter(FavoriteList.favoriteList) {}

        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.adapter = adapter2

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        adapter2.notifyDataSetChanged()
    }
}