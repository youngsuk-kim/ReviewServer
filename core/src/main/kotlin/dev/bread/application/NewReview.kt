package dev.bread.application

import dev.bread.domain.Review
import dev.bread.domain.ReviewContent
import dev.bread.domain.ReviewMenu

data class NewReview(
    val memberId: Long,
    val reviewMenus: MutableList<NewMenu>,
    val content: NewReviewContent,
    val visibleToOwner: Boolean
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
            visibleToOwner = this.visibleToOwner
        )
    }
}
