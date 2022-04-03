package com.uluumbch.daftarmotogp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uluumbch.daftarmotogp.R
import com.uluumbch.daftarmotogp.data.Data

class MyAdapter :
    RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {
    private val data = Data.myData

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.picture)
        val country: ImageView = view.findViewById(R.id.person_country)
        val nameTextview: TextView = view.findViewById(R.id.person_name)
        val bikeTextView: TextView = view.findViewById(R.id.person_bike)
        val dobTextView: TextView = view.findViewById(R.id.person_DOB)
        val heightTextView: TextView = view.findViewById(R.id.person_height)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_of_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        holder.image.setImageResource(item.imageResourceId)
        holder.country.setImageResource(item.countryIcon)
        holder.nameTextview.text = item.stringName
        holder.bikeTextView.text = item.bike
        holder.dobTextView.text = item.DOB
        holder.heightTextView.text = item.height
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
