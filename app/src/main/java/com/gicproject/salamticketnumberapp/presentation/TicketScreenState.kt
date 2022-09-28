package com.gicproject.salamticketnumberapp.presentation

import com.gicproject.salamticketnumberapp.domain.model.TicketNumber


data class TicketScreenState(
    val isLoading: Boolean = false,
    val isLoadingSubmit: Boolean = false,
    val ticketNumber: TicketNumber = TicketNumber(0,""),
    val success: String = "",
    val error: String = ""
)
