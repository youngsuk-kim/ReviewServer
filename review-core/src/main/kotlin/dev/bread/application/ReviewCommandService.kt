package dev.bread.application

import dev.bread.storage.entity.Review
import org.springframework.stereotype.Service

@Service
class ReviewCommandService(
    private val reviewAppender: ReviewAppender,
    private val reviewUpdater: ReviewUpdater,
    private val reviewRemover: ReviewRemover
) {

    fun create(newReview: NewReview): Review {
        return reviewAppender.save(newReview)
    }

    fun update(updateReview: UpdateReview) {
        reviewUpdater.update(updateReview)
    }

    fun delete(reviewId: Long) {
        reviewRemover.delete(reviewId)
    }
}
