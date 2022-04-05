package com.example.menuhomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.menuhomework.FavoriteList.favoriteList


class MainAdapter(
    private val foodModelList: MutableList<FoodModel>,
    private val onItemClick: (foodModel: FoodModel) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.food_items, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tempFoodModel = foodModelList[position]
        holder.bind(tempFoodModel)
    }

    override fun getItemCount(): Int = foodModelList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tv_foodname)
        val rName = itemView.findViewById<TextView>(R.id.r_name)
        val rating = itemView.findViewById<TextView>(R.id.rating)
        val imgFood = itemView.findViewById<ImageView>(R.id.img_food_avatars)
        val addFavorite = itemView.findViewById<ImageView>(R.id.add_favorite)
        val price = itemView.findViewById<TextView>(R.id.price_value)
        val ratingStar = itemView.findViewById<ImageView>(R.id.imageView)

        fun bind(foodModel: FoodModel) {
            name.text = foodModel.naame
            rName.text = foodModel.rName
            rating.text = foodModel.rating.toString()
            price.text = foodModel.price.toString() + " դ․"
            imgFood.setImageResource(foodModel.imageId)

            var a = false
            fun plusRating() {
                if (!a) {
                    foodModel.rating = rating.text.toString().toInt() + 1
                    rating.text = (rating.text.toString().toInt() + 1).toString()
                    a = true
                }
            }

            rating.setOnClickListener { plusRating() }
            ratingStar.setOnClickListener { plusRating() } //  plus rating

            addFavorite.setOnClickListener {
                FavoriteList.totalPrice += foodModel.price
                favoriteList += foodModel
                onItemClick.invoke(foodModel)
            }//addFavorite

        }
    }
}