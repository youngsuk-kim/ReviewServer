package dev.bread.application.implementation

import dev.bread.controller.v1.request.SaveReviewRequest
import dev.bread.controller.v1.request.UpdateReviewRequest
import dev.bread.domain.Review
import dev.bread.domain.ReviewRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class ReviewWriter(
    private val reviewRepository: ReviewRepository
) {

    fun save(request: SaveReviewRequest): Long? {
        val review = reviewRepository.save(request.convert())

        return review.reviewId
    }

    fun update(request: UpdateReviewRequest) {
        reviewRepository.save(request.convert())
    }
}
