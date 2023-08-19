package dev.bread.storage.data

data class ReviewMenuResult(
    val koName: String,
    val enName: String,
    val secretMenu: Boolean,
    val menuRate: Int,
    val recommend: Boolean
)
