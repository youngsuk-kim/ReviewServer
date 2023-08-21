package dev.bread.application

import dev.bread.domain.Review
import dev.bread.domain.repository.ReviewRepository
import org.springframework.stereotype.Component

@Component
class ReviewFinder(
    private val reviewRepository: ReviewRepository
) {

    fun find(reviewId: Long): Review {
        return reviewRepository.findById(reviewId)
    }
}
