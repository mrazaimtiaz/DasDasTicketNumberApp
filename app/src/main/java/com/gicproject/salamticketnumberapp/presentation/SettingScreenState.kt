package com.gicproject.salamticketnumberapp.presentation

import com.gicproject.emojisurveyapp.domain.model.Location

data class SettingScreenState(
    val isLoading: Boolean = false,
    val isLoadingPagination: Boolean = false,
    val locations: List<Location> = emptyList(),
    val error: String = ""
)
