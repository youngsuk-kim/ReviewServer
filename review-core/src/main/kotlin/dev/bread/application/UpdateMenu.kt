package dev.bread.application

data class UpdateMenu(
    val recommend: Boolean,
    val secretMenu: Boolean,
    val menuRate: Int,
    val menuId: Long
)
