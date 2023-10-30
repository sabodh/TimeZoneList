package com.sample.mapping.data.network.api

import com.sample.mapping.data.entity.TimeZoneMember
import retrofit2.Response
import retrofit2.http.GET

interface TimeZoneApi {
    @GET("/timezone.json")
    suspend fun getRooms(): Response<List<TimeZoneMember>>
}
