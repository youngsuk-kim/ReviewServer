package dev.bread.application

data class ReviewResult(
    val userName: String,
    val menu: List<Menu>?,
    val reviewCount: Int?,
    val averageRate: Double?,
    val storeRate: Int?
)
data class Menu(
    val koName: String,
    val enName: String,
    val recommend: Boolean
)
