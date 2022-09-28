package com.gicproject.salamticketnumberapp.presentation


sealed class MyEvent {
     object GetLocation: MyEvent()
     object GetTicket: MyEvent()
     object GetBlinkCount: MyEvent()
}

