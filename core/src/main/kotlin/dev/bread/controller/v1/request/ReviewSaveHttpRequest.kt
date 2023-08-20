package dev.bread.controller.v1.request

import dev.bread.application.NewMenu
import dev.bread.application.NewReview
import dev.bread.application.NewReviewContent
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class ReviewSaveHttpRequest(

    @NotNull
    val memberId: Long,

    val deliverySatisfied: Boolean,

    @Max(value = 5000)
    val deliveryReviewReason: String?,

    @NotNull
    val storeId: Long,

    @NotNull
    val menus: List<ReviewMenuSaveHttpRequest>,

    @Max(value = 5000)
    val reviewText: String,

    @Min(value = 5)
    @Positive
    val storeRate: Int,

    val visibleToOwner: Boolean
) {
    fun toNewReview(): NewReview {
        return NewReview(
            memberId = this.memberId,

            reviewMenus = this.menus.map {
                NewMenu(
                    recommend = it.recommend,
                    secretMenu = it.secretMenu,
                    menuRate = it.menuRate,
                    menuId = it.menuId
                )
            }.toMutableList(),

            content = NewReviewContent(
                rate = this.storeRate,
                text = this.reviewText
            ),

            visibleToOwner = this.visibleToOwner
        )
    }
}

