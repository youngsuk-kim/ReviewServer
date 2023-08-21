package dev.bread.core.application

import dev.bread.storage.entity.Review
import dev.bread.storage.entity.ReviewContent
import dev.bread.storage.entity.ReviewMenu

data class NewReview(
    val memberId: Long,
    val reviewMenus: List<NewMenu>,
    val content: NewReviewContent,
    val visibleOwner: Boolean
) {
    fun toDomain(): Review {
        return Review(
            memberId = this.memberId,
            reviewMenus = this.reviewMenus.map {
                ReviewMenu(
                    recommend = it.recommend,
                    secretMenu = it.secretMenu,
                    menuRate = it.menuRate,
                    menuId = it.menuId
                )
            }.toMutableList(),
            content = ReviewContent(rate = this.content.rate, text = this.content.text),
            visibleOwner = this.visibleOwner
        )
    }
}
