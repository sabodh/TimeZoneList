package com.sample.mapping.data.repository

import com.sample.mapping.data.entity.TimeZoneMember
import com.sample.mapping.data.network.api.TimeZoneApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TimeZoneRepository @Inject constructor(
    private val timeZoneApi: TimeZoneApi
) {

    suspend fun getTimezoneList(): List<TimeZoneMember> {
        var timezoneList: List<TimeZoneMember> = emptyList()

        withContext(Dispatchers.IO) {
            timeZoneApi.getRooms().body()?.let {
                timezoneList = it
            }
        }

        return timezoneList
    }
}
