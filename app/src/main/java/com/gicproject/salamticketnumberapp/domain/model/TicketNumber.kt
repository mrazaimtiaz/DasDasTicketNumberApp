package com.gicproject.salamticketnumberapp.domain.model

import com.google.gson.annotations.SerializedName

data class TicketNumber(
    @SerializedName("CounterStatus")
    var status: Int? = null,
    @SerializedName("BookedNumber")
    var number: String? = null
)
