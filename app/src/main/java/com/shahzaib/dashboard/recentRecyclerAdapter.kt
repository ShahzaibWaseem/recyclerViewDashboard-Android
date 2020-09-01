package com.shahzaib.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class RecentRecyclerAdapter (private var list: MutableList<Recent>, private val context: Context) :
    RecyclerView.Adapter<RecentRecyclerAdapter.CustomViewHolder>(){
    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.recentValueIcon)
        val text: TextView = view.findViewById(R.id.recentValueText)
        val tag: TextView = view.findViewById(R.id.recentTag)
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recent_recycler_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: CustomViewHolder, position: Int) {
        holder.image.setImageBitmap(list[position].image)
        holder.text.text = list[position].text
        holder.tag.text = list[position].tag
    }

    override fun getItemCount() = list.size
}