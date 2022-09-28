package com.gicproject.salamticketnumberapp.data.remote.dto

import com.gicproject.emojisurveyapp.domain.model.Location
import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("PKID") var PKID: Int? = null,
    @SerializedName("CounterName") var CounterName: String? = null
){
    fun toLocation(): Location {
        return Location(
            ID = PKID,
            Name = CounterName,
        )
    }
}
