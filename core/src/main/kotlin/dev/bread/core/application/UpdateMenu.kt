package dev.bread.core.application

data class UpdateMenu(
    val recommend: Boolean,
    val secretMenu: Boolean,
    val menuRate: Int,
    val menuId: Long
)
