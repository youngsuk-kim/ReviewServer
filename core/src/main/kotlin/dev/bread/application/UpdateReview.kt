package dev.bread.application

import dev.bread.domain.Review
import dev.bread.domain.ReviewContent
import dev.bread.domain.ReviewMenu

data class UpdateReview(
    val reviewId: Long,
    val memberId: Long,
    val reviewMenus: MutableList<UpdateMenu>,
    val content: UpdateContent,
    val visibleToOwner: Boolean
) {
    fun toDomain(): Review {
        return Review(
            reviewId = this.reviewId,
            memberId = this.memberId,
            reviewMenus = this.reviewMenus.map {
                ReviewMenu(
                    recommend = it.recommend,
                    secretMenu = it.secretMenu,
                    menuRate = it.menuRate,
                    menuId = it.menuId
                )
            }.toMutableList(),
            content = ReviewContent(rate = this.content.rate, this.content.text),
            visibleToOwner = this.visibleToOwner
        )
    }
}
