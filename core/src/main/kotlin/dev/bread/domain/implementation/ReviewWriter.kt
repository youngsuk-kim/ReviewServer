package dev.bread.domain.implementation

import dev.bread.controller.v1.request.SaveReviewRequest
import dev.bread.storage.entity.Review
import dev.bread.storage.repository.ReviewRepository
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
