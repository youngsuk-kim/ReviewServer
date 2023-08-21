package dev.bread.application

import org.springframework.stereotype.Service

@Service
class ReviewCommandService(
    private val reviewAppender: ReviewAppender
) {

    fun create(newReview: NewReview): Long {
        return reviewAppender.save(newReview)
    }

    fun update(updateReview: UpdateReview) {
        reviewAppender.update(updateReview)
    }

    fun delete(reviewId: Long) {
        reviewAppender.delete(reviewId)
    }
}
