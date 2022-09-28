package com.gicproject.salamticketnumberapp.data.remote

import com.gicproject.salamticketnumberapp.data.remote.dto.LocationDto
import com.gicproject.salamticketnumberapp.domain.model.BlinkingCount
import com.gicproject.salamticketnumberapp.domain.model.TicketNumber
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

    @GET("api/getCounters")
    suspend fun getLocations(
    ): List<LocationDto>?

    @GET("api/checkCounterStatus")
    suspend fun checkCounterStatus(
        @Query("PKID")
        id: String,
    ): List<TicketNumber>?

    @GET("api/getBlinkingCount")
    suspend fun getBlinkCount(
    ): List<BlinkingCount>?



}