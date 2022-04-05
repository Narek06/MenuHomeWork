package com.example.menuhomework

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.my_rec_view)

        adapter = MainAdapter(FoodList.foodModel) {

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("ID", it.imageId)
            intent.putExtra("NAME", it.naame)
            intent.putExtra("PRICE", it.price)
            intent.putExtra("RNAME", it.rName)
            intent.putExtra("ID_USERS", it.id_food)
            intent.putExtra("RATING", it.rating)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        adapter.notifyDataSetChanged()
    }

}