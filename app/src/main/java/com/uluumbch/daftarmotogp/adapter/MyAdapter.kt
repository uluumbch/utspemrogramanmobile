package com.uluumbch.daftarmotogp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uluumbch.daftarmotogp.R
import com.uluumbch.daftarmotogp.data.Data

class MyAdapter() :
    RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {
    private val data = Data.myData
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(postition: Int){

        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    class ItemViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.picture)
        val country: ImageView = view.findViewById(R.id.person_country)
        val nameTextview: TextView = view.findViewById(R.id.person_name)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_of_item, parent, false)
        return ItemViewHolder(adapterLayout, mListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        holder.image.setImageResource(item.imageResourceId)
        holder.country.setImageResource(item.countryIcon)
        holder.nameTextview.text = item.stringName
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
