package dev.bread.application

import dev.bread.domain.Review
import org.springframework.stereotype.Service

@Service
class ReviewQueryService(
    private val reviewFinder: ReviewFinder
) {
    fun getOne(reviewId: Long, memberId: Long): Review {
        return reviewFinder.find(reviewId)
    }
}
