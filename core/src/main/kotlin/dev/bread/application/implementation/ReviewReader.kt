package dev.bread.application.implementation

import dev.bread.domain.Review
import dev.bread.domain.ReviewRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional(readOnly = true)
class ReviewReader(
    private val reviewRepository: ReviewRepository
) {
    fun read(reviewId: Long): Review? {
        return reviewRepository.findById(reviewId)
    }

    fun readByMemberId(memberId: Long): List<Review>? {
        return reviewRepository.findAllByMemberId(memberId)
    }
}
