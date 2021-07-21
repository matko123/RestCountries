package com.example.kotlinreseno

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


import kotlinx.android.synthetic.main.example_item.view.*

class ExampleAdapter(private val exampleList: List<Model>, val activity: Activity) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
            parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val trenutniIndex = exampleList[position]

        
        
        val IMAGE_URI = Uri.parse(trenutniIndex.CountryFlag)

        GlideToVectorYou.justLoadImage(activity, IMAGE_URI, holder.imageView)

        holder.textView1.text = "Country: " + trenutniIndex.CountryName.orEmpty()
        holder.textView2.text = "Population: " + trenutniIndex.CountryPopulation.orEmpty()
        holder.textView3.text = "Area: " + trenutniIndex.CountryArea.orEmpty().replace(".0", "") + " km^2"

    }

    override fun getItemCount() = exampleList.size

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2
        val textView3: TextView = itemView.text_view_3
    }
}