package com.gicproject.salamticketnumberapp.domain.model

import com.google.gson.annotations.SerializedName

data class BlinkingCount(
    @SerializedName("blinkingCount")
    var blinkingCount: Int? = null,
)
