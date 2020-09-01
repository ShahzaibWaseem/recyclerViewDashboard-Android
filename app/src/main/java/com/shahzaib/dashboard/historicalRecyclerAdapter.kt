package com.shahzaib.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class HistoricalRecyclerAdapter (private var list: MutableList<Historical>, private val context: Context) :
    RecyclerView.Adapter<HistoricalRecyclerAdapter.CustomViewHolder>(){
    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.historicalIcon)
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.historical_recycler_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: CustomViewHolder, position: Int) {
        holder.image.setImageBitmap(list[position].image)
    }

    override fun getItemCount() = list.size
}