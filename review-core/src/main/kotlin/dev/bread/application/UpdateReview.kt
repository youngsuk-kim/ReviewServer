package dev.bread.application

import dev.bread.storage.entity.Review
import dev.bread.storage.entity.ReviewContent
import dev.bread.storage.entity.ReviewMenu

data class UpdateReview(
    val reviewId: Long,
    val memberId: Long,
    val reviewMenus: MutableList<UpdateMenu>,
    val content: UpdateContent,
    val visibleOwner: Boolean
) {
    fun toEntity(): Review {
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
            content = ReviewContent(rate = this.content.rate, this.content.text),
            visibleOwner = this.visibleOwner
        )
    }
}
