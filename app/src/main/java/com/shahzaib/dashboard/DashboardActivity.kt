package com.shahzaib.dashboard

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.shahzaib.dashboard.databinding.DashboardActivityBinding


class DashboardActivity: AppCompatActivity() {
    private lateinit var binding: DashboardActivityBinding

    private lateinit var recentRecyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var scheduleRecyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var historicalRecyclerAdapter: RecyclerView.Adapter<*>

    private var recentList: MutableList<Recent> =  mutableListOf()
    private var scheduleList: MutableList<Schedule> =  mutableListOf()
    private var historicalList: MutableList<Historical> =  mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DashboardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillDummyData()

        binding.recentRecyclerView.apply {
            recentRecyclerAdapter = RecentRecyclerAdapter(recentList, this@DashboardActivity)
            binding.recentRecyclerView.adapter = recentRecyclerAdapter
        }

        binding.scheduleRecyclerView.apply {
            scheduleRecyclerAdapter = ScheduleRecyclerAdapter(scheduleList, this@DashboardActivity)
            binding.scheduleRecyclerView.adapter = scheduleRecyclerAdapter
        }

        binding.historicalRecyclerView.apply {
            historicalRecyclerAdapter = HistoricalRecyclerAdapter(
                historicalList,
                this@DashboardActivity
            )
            binding.historicalRecyclerView.adapter = historicalRecyclerAdapter
        }
    }

    private fun fillDummyData() {
//        val pillImage = BitmapFactory.decodeResource(resources, R.drawable.ic_compliance_pill)
        val pillImage = drawableToBitmap(resources.getDrawable(R.mipmap.ic_launcher))
        val heartRateImage = drawableToBitmap(resources.getDrawable(R.mipmap.ic_launcher))
        val tempImage = drawableToBitmap(resources.getDrawable(R.mipmap.ic_launcher))

        val bpRecent: Recent = Recent(heartRateImage!!, "120/80", "B.P.")
        val tempRecent: Recent = Recent(heartRateImage, "33", "TEMP")
        recentList.add(bpRecent)
        recentList.add(tempRecent)
        recentList.add(bpRecent)
        recentList.add(tempRecent)
        recentList.add(bpRecent)
        recentList.add(tempRecent)

        val panadolSchedule1: Schedule = Schedule(pillImage!!, "01:00 PM", "Panadol")
        val panadolSchedule2: Schedule = Schedule(pillImage, "06:00 PM", "Panadol")
        scheduleList.add(panadolSchedule1)
        scheduleList.add(panadolSchedule2)
        scheduleList.add(panadolSchedule1)
        scheduleList.add(panadolSchedule2)
        scheduleList.add(panadolSchedule1)
        scheduleList.add(panadolSchedule2)

        val bpHistorical: Historical = Historical(heartRateImage)
        val tempHistorical: Historical = Historical(heartRateImage)
        historicalList.add(bpHistorical)
        historicalList.add(tempHistorical)
        historicalList.add(bpHistorical)
        historicalList.add(tempHistorical)
        historicalList.add(bpHistorical)
        historicalList.add(tempHistorical)
    }

    fun drawableToBitmap(drawable: Drawable): Bitmap? {
        if (drawable is BitmapDrawable) {
            return drawable.bitmap
        }
        val bitmap =
            Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
        drawable.draw(canvas)
        return bitmap
    }
}