package dev.bread.application

data class ReviewResult(
    val userName: String?,
    val menu: List<MenuResult>?,
    val reviewCount: Int?,
    val averageRate: Double?,
    val storeRate: Int?
)
data class MenuResult(
    val koName: String,
    val enName: String,
    val recommend: Boolean
)
