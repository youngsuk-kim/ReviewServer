package dev.bread.application

import dev.bread.storage.entity.ReviewContent
import dev.bread.storage.entity.ReviewMenu
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class ReviewUpdater(
    private val reviewFinder: ReviewFinder
) {

    fun update(updateReview: UpdateReview) {
        val review = reviewFinder.find(updateReview.reviewId)
        review.update(
            reviewMenus = updateReview.reviewMenus.map {
                ReviewMenu(
                    it.recommend,
                    it.secretMenu,
                    it.menuRate,
                    it.menuId
                )
            }.toMutableList(),
            content = ReviewContent(updateReview.content.rate, updateReview.content.text)
        )
    }
}