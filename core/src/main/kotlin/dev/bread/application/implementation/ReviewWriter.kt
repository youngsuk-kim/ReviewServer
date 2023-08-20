package dev.bread.application.implementation

import dev.bread.controller.v1.request.SaveReviewRequest
import dev.bread.domain.Review
import dev.bread.domain.ReviewRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ReviewWriter(
    private val reviewRepository: ReviewRepository
) {

    @Transactional
    fun save(request: SaveReviewRequest): Review {
        return reviewRepository.save(request.convert())
    }
}
