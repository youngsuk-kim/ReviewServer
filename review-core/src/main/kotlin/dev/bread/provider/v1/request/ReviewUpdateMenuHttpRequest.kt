package dev.bread.provider.v1.request

data class ReviewUpdateMenuHttpRequest(
    val menuId: Long,
    val recommend: Boolean,
    val secretMenu: Boolean,
    val menuRate: Int
)
