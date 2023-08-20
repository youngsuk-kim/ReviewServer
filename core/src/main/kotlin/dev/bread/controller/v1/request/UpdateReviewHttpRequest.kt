package dev.bread.controller.v1.request

import dev.bread.domain.Review
import dev.bread.domain.ReviewContent
import dev.bread.domain.ReviewMenu

data class UpdateReviewHttpRequest(
    val memberId: Long,
    val reviewId: Long,
    val visibleToOwner: Boolean,
    val storeRate: Int,
    val reviewText: String,
    val menu: List<UpdateMenu>
) {
    fun toReview(): Review {
        return Review(
            reviewId = this.reviewId,
            memberId = this.memberId,
            reviewMenus = menu.map {
                ReviewMenu(
                    recommend = it.recommend,
                    secretMenu = it.secretMenu,
                    menuRate = it.menuRate,
                    menuId = it.menuId
                )
            }.toMutableList(),
            content = ReviewContent(rate = this.storeRate, text = this.reviewText),
            visibleToOwner = this.visibleToOwner
        )
    }
}

data class UpdateMenu(
    val menuId: Long,
    val recommend: Boolean,
    val secretMenu: Boolean,
    val menuRate: Int
)
