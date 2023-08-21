package dev.bread.core.application

import dev.bread.storage.entity.Review
import org.springframework.stereotype.Service

@Service
class ReviewCommandService(
    private val reviewAppender: ReviewAppender
) {

    fun create(newReview: NewReview): Review {
        return reviewAppender.save(newReview)
    }

    fun update(updateReview: UpdateReview) {
        reviewAppender.update(updateReview)
    }

    fun delete(reviewId: Long) {
        reviewAppender.delete(reviewId)
    }
}
