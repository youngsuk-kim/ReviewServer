package dev.bread.presenter.v1.request

import dev.bread.storage.entity.Review
import dev.bread.storage.entity.ReviewContent
import dev.bread.storage.entity.ReviewDelivery
import dev.bread.storage.entity.ReviewMenu
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class SaveReviewRequest(

    @NotNull
    val memberId: Long,

    val deliverySatisfied: Boolean,

    @Max(value = 5000)
    val deliveryReviewReason: String?,

    @NotNull
    val storeId: Long,

    @NotNull
    val menu: List<Menu>,

    @Max(value = 5000)
    val reviewText: String,

    @Min(value = 5)
    @Positive
    val storeRate: Int,

    val visibleToOwner: Boolean
) {
    fun convert(): Review {
        return Review(
            memberId = this.memberId,

            reviewMenus = this.menu.map {
                ReviewMenu(
                    recommend = it.recommend,
                    secretMenu = it.secretMenu,
                    menuRate = it.menuRate,
                    menuId = it.menuId
                )
            }.toMutableList(),

            reviewDelivery = ReviewDelivery(
                satisfied = this.deliverySatisfied,
                reason = this.deliveryReviewReason
            ),

            content = ReviewContent(
                rate = this.storeRate,
                text = this.reviewText
            ),

            visibleToOwner = this.visibleToOwner
        )
    }
}

data class Menu(
    val recommend: Boolean,
    val secretMenu: Boolean,
    @NotNull
    val menuId: Long,
    @Min(value = 5)
    @Positive
    val menuRate: Int
)
