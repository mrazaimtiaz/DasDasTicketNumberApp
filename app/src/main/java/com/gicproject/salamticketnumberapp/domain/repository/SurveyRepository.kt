package com.gicproject.salamticketnumberapp.domain.repository

import com.gicproject.salamticketnumberapp.data.remote.dto.LocationDto
import com.gicproject.salamticketnumberapp.domain.model.BlinkingCount
import com.gicproject.salamticketnumberapp.domain.model.TicketNumber

interface MyRepository {
    suspend fun getLocations(): List<LocationDto>?

    suspend fun getCounterStatus(id: String): List<TicketNumber>?

    suspend fun getBlinkingCount(): List<BlinkingCount>?
}