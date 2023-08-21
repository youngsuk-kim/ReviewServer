package dev.bread.provider.v1.request

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class ReviewMenuSaveHttpRequest(
    val recommend: Boolean,
    val secretMenu: Boolean,
    @NotNull
    val menuId: Long,
    @Min(value = 5)
    @Positive
    val menuRate: Int
)
