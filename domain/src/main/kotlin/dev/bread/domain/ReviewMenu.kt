package dev.bread.domain

data class ReviewMenu(
    val recommend: Boolean,
    val secretMenu: Boolean,
    val menuRate: Int,
    val koName: String? = null,
    val enName: String? = null,
    val menuId: Long
)
