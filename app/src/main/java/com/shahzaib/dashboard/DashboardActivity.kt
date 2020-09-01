package com.shahzaib.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
}