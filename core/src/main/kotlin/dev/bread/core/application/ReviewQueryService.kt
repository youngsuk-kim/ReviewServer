package dev.bread.core.application

import dev.bread.storage.entity.Review
import org.springframework.stereotype.Service

@Service
class ReviewQueryService(
    private val reviewFinder: ReviewFinder
) {
    fun getOne(reviewId: Long, memberId: Long): Review {
        return reviewFinder.find(reviewId)
    }
}
