package com.gicproject.emojisurveyapp.domain.utils

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.OrderType

sealed class CustomerInputOrder(val orderType: OrderType) {
    class QuestionId(orderType: OrderType): CustomerInputOrder(orderType)
    class Location(orderType: OrderType): CustomerInputOrder(orderType)
    class MobileNumber(orderType: OrderType): CustomerInputOrder(orderType)
    class Timestamp(orderType: OrderType): CustomerInputOrder(orderType)
    class InputId(orderType: OrderType): CustomerInputOrder(orderType)
    class InputMessage(orderType: OrderType): CustomerInputOrder(orderType)
    class IsSaved(orderType: OrderType): CustomerInputOrder(orderType)

    fun copy(orderType: OrderType): CustomerInputOrder {
        return when(this) {
            is QuestionId -> QuestionId(orderType)
            is Location -> Location(orderType)
            is MobileNumber -> MobileNumber(orderType)
            is Timestamp -> Timestamp(orderType)
            is InputId -> InputId(orderType)
            is InputMessage -> InputMessage(orderType)
            is IsSaved -> IsSaved(orderType)
        }
    }
}

