package dev.bread.application

data class ReadOneReviewCommand(
    val userName: String?,
    val reviewCount: Int?,
    val menus: List<ReadOneMenuCommand>?,
    val averageRate: Double?,
    val storeRate: Int?
)
