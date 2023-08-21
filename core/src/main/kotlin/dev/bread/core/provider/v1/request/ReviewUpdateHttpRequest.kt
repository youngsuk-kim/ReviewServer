package dev.bread.core.provider.v1.request

import dev.bread.core.application.UpdateContent
import dev.bread.core.application.UpdateMenu
import dev.bread.core.application.UpdateReview

data class ReviewUpdateHttpRequest(
    val memberId: Long,
    val reviewId: Long,
    val visibleToOwner: Boolean,
    val storeRate: Int,
    val reviewText: String,
    val menu: List<ReviewUpdateMenuHttpRequest>
) {
    fun toUpdateReview(): UpdateReview {
        return UpdateReview(
            reviewId = this.reviewId,
            memberId = this.memberId,
            reviewMenus = menu.map {
                UpdateMenu(
                    recommend = it.recommend,
                    secretMenu = it.secretMenu,
                    menuRate = it.menuRate,
                    menuId = it.menuId
                )
            }.toMutableList(),
            content = UpdateContent(rate = this.storeRate, text = this.reviewText),
            visibleOwner = this.visibleToOwner
        )
    }
}
