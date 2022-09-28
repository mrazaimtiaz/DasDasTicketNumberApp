package com.gicproject.salamticketnumberapp

sealed class Screen(val route: String) {
    object TicketScreen: Screen("ticket_screen")
    object SettingScreen: Screen("setting_screen")
}
