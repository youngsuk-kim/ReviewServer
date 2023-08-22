package dev.bread.application

import dev.bread.storage.entity.ReviewContent
import dev.bread.storage.entity.ReviewMenu
import dev.bread.support.Transaction
import org.springframework.stereotype.Component

@Component
class ReviewUpdater(
    private val reviewFinder: ReviewFinder
) {

    fun update(updateReview: UpdateReview) {
        val updateMenu = updateReview.reviewMenus.map {
            ReviewMenu(
                recommend = it.recommend,
                secretMenu = it.secretMenu,
                menuRate = it.menuRate,
                menuId = it.menuId
            )
        }

        val reviewContent = ReviewContent(
            rate = updateReview.content.rate,
            text = updateReview.content.text
        )

        executeUpdateTx(updateReview, updateMenu, reviewContent)
    }

    private fun executeUpdateTx(
        updateReview: UpdateReview,
        updateMenu: List<ReviewMenu>,
        reviewContent: ReviewContent
    ) {
        Transaction.start {
            reviewFinder.find(updateReview.reviewId).also {
                it.update(
                    reviewMenus = updateMenu.toMutableList(),
                    content = reviewContent
                )
            }
        }
    }
}
