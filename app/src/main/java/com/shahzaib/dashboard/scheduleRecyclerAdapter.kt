package com.shahzaib.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class ScheduleRecyclerAdapter (private var list: MutableList<Schedule>, private val context: Context) :
    RecyclerView.Adapter<ScheduleRecyclerAdapter.CustomViewHolder>(){
    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.scheduleValueIcon)
        val time: TextView = view.findViewById(R.id.scheduleTimeText)
        val tag: TextView = view.findViewById(R.id.scheduleTag)
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.schedule_recycler_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: CustomViewHolder, position: Int) {
        holder.image.setImageBitmap(list[position].image)
        holder.time.text = list[position].time
        holder.tag.text = list[position].tag
    }

    override fun getItemCount() = list.size
}