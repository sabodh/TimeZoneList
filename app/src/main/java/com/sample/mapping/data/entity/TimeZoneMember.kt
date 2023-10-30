package com.sample.mapping.data.entity

import java.util.Calendar
import java.util.TimeZone

data class TimeZoneMember(
    val name: String,
    val timezone: String,
    val currentTime: String
)
fun getCurrentTimeAndFormat(zone: String): String =
    with(Calendar.getInstance().apply {
        timeZone = TimeZone.getTimeZone(zone)
    }) {
        "${String.format("%02d", this[Calendar.HOUR_OF_DAY])}:${
            String.format(
                "%02d",
                this[Calendar.MINUTE]
            )
        }:${String.format("%02d", this[Calendar.SECOND])}"
    }