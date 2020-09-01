package com.shahzaib.dashboard

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.shahzaib.dashboard.databinding.DashboardActivityBinding

class DashboardActivity: AppCompatActivity() {
    private lateinit var binding: DashboardActivityBinding
    private lateinit var recentRecyclerView: RecyclerView
    private lateinit var recentRecyclerAdapter: RecyclerView.Adapter<*>

    private lateinit var scheduleRecyclerView: RecyclerView
    private lateinit var scheduleRecyclerAdapter: RecyclerView.Adapter<*>

    private lateinit var historicalRecyclerView: RecyclerView
    private lateinit var historicalRecyclerAdapter: RecyclerView.Adapter<*>

    private var recentList: MutableList<Recent> =  mutableListOf()
    private var scheduleList: MutableList<Schedule> =  mutableListOf()
    private var historicalList: MutableList<Historical> =  mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DashboardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillDummyData()

        recentRecyclerView = binding.recentRecyclerView.apply {
            recentRecyclerAdapter = RecentRecyclerAdapter(recentList, this@DashboardActivity)
            recentRecyclerView.adapter = recentRecyclerAdapter
        }

        scheduleRecyclerView = binding.scheduleRecyclerView.apply {
            scheduleRecyclerAdapter = ScheduleRecyclerAdapter(scheduleList, this@DashboardActivity)
            scheduleRecyclerView.adapter = scheduleRecyclerAdapter
        }

        historicalRecyclerView = binding.historicalRecyclerView.apply {
            historicalRecyclerAdapter = HistoricalRecyclerAdapter(historicalList, this@DashboardActivity)
            historicalRecyclerView.adapter = historicalRecyclerAdapter
        }
    }

    private fun fillDummyData() {
        val pillImage = BitmapFactory.decodeResource(resources, R.drawable.ic_compliance_pill)
        val heartRateImage = BitmapFactory.decodeResource(resources, R.drawable.ic_compliance_test)
        val tempImage = BitmapFactory.decodeResource(resources, R.drawable.ic_sc_header_icon)

        val bpRecent: Recent = Recent(heartRateImage, "120/80", "B.P.")
        val tempRecent: Recent = Recent(tempImage, "33", "TEMP")
        recentList.add(bpRecent)
        recentList.add(tempRecent)

        val panadolSchedule1: Schedule = Schedule(pillImage, "01:00 PM", "Panadol")
        val panadolSchedule2: Schedule = Schedule(pillImage, "06:00 PM", "Panadol")
        scheduleList.add(panadolSchedule1)
        scheduleList.add(panadolSchedule2)

        val bpHistorical: Historical = Historical(heartRateImage)
        val tempHistorical: Historical = Historical(tempImage)
        historicalList.add(bpHistorical)
        historicalList.add(tempHistorical)
    }
}