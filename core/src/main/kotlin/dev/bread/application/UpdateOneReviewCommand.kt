package dev.bread.application

import dev.bread.domain.Review
import dev.bread.domain.ReviewContent
import dev.bread.domain.ReviewMenu

data class UpdateOneReviewCommand(
    val reviewId: Long,
    val memberId: Long,
    val reviewMenus: MutableList<UpdateOneMenuCommand>,
    val content: ReviewContent,
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

data class UpdateOneMenuCommand(
    val recommend: Boolean,
    val secretMenu: Boolean,
    val menuRate: Int,
    val menuId: Long
)
