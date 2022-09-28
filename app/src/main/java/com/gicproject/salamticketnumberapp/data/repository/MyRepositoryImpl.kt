package com.gicproject.salamticketnumberapp.data.repository


import com.gicproject.salamticketnumberapp.data.remote.dto.LocationDto
import com.gicproject.salamticketnumberapp.data.remote.MyApi
import com.gicproject.salamticketnumberapp.domain.model.BlinkingCount
import com.gicproject.salamticketnumberapp.domain.model.TicketNumber
import com.gicproject.salamticketnumberapp.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi
): MyRepository {

    override suspend fun getLocations(): List<LocationDto>? {
        return api.getLocations()
    }

    override suspend fun getCounterStatus(id: String): List<TicketNumber>? {
        return  api.checkCounterStatus(id.toString())
    }

    override suspend fun getBlinkingCount(): List<BlinkingCount>? {
        return api.getBlinkCount()
    }


}