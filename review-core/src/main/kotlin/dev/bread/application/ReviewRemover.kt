package dev.bread.application

import dev.bread.support.Transaction
import org.springframework.stereotype.Component

@Component
class ReviewRemover(
    private val reviewFinder: ReviewFinder
) {
    fun delete(reviewId: Long) {
        Transaction.start {
            reviewFinder.find(reviewId).delete()
        }
    }
}
