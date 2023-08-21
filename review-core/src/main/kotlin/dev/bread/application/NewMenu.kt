package dev.bread.application

data class NewMenu(
    val recommend: Boolean,
    val secretMenu: Boolean,
    val menuRate: Int,
    val menuId: Long
)
