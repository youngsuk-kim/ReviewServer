package dev.bread.controller.v1.request

import dev.bread.application.UpdateOneMenuCommand
import dev.bread.application.UpdateOneReviewCommand
import dev.bread.domain.ReviewContent

data class UpdateReviewHttpRequest(
    val memberId: Long,
    val reviewId: Long,
    val visibleToOwner: Boolean,
    val storeRate: Int,
    val reviewText: String,
    val menu: List<UpdateMenuHttpRequest>
) {
    fun toCommand(): UpdateOneReviewCommand {
        return UpdateOneReviewCommand(
            reviewId = this.reviewId,
            memberId = this.memberId,
            reviewMenus = menu.map {
                UpdateOneMenuCommand(
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

data class UpdateMenuHttpRequest(
    val menuId: Long,
    val recommend: Boolean,
    val secretMenu: Boolean,
    val menuRate: Int
)
