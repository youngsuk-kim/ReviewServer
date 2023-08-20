package dev.bread.application

import dev.bread.application.implementation.ReviewReader
import dev.bread.domain.Review
import org.springframework.stereotype.Service

@Service
class ReviewQueryService(
    private val reviewReader: ReviewReader
) {

    fun readOne(reviewId: Long, memberId: Long): Review {
        return reviewReader.read(reviewId)
    }
}
