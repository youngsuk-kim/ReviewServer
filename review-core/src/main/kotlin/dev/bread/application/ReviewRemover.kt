package dev.bread.application

import dev.bread.storage.repository.ReviewRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class ReviewRemover(
    private val reviewFinder: ReviewFinder
) {
    fun delete(reviewId: Long) {
        val review = reviewFinder.find(reviewId)
        review.delete()
    }
}