package com.sample.mapping.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.mapping.data.entity.TimeZoneMember
import com.sample.mapping.databinding.ItemTimezoneBinding
import java.util.*

class TimeZoneAdapter(
    var timeZoneList: List<TimeZoneMember>
) : RecyclerView.Adapter<TimeZoneAdapter.TimeZoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeZoneViewHolder {
        val binding = ItemTimezoneBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TimeZoneViewHolder(binding)
    }

    override fun getItemCount() = timeZoneList.size

    override fun onBindViewHolder(holder: TimeZoneViewHolder, position: Int) {
        with(holder) {
            with(timeZoneList[position]) {
                binding.tvName.text = name
                binding.tvTime.text = currentTime
            }
        }
    }

    inner class TimeZoneViewHolder(val binding: ItemTimezoneBinding) :
        RecyclerView.ViewHolder(binding.root)

}
