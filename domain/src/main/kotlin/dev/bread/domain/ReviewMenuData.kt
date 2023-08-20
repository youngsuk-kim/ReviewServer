package dev.bread.domain

data class ReviewMenuData(
    val koName: String,
    val enName: String,
    val secretMenu: Boolean,
    val menuRate: Int,
    val recommend: Boolean
)
