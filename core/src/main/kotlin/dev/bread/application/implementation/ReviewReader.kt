package dev.bread.application.implementation

import dev.bread.domain.Review
import dev.bread.domain.repository.ReviewRepository
import org.springframework.stereotype.Component

@Component
class ReviewReader(
    private val reviewRepository: ReviewRepository
) {

    fun read(reviewId: Long): Review {
        return reviewRepository.findById(reviewId)
    }
}
