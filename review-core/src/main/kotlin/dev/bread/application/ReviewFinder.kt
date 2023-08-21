package dev.bread.application

import dev.bread.storage.entity.Review
import dev.bread.storage.repository.ReviewRepository
import dev.bread.support.error.CoreException
import dev.bread.support.error.ErrorType
import org.springframework.stereotype.Component

@Component
class ReviewFinder(
    private val reviewRepository: ReviewRepository
) {

    fun find(reviewId: Long): Review {
        return reviewRepository.findById(reviewId)
            .orElseThrow { throw CoreException(ErrorType.NOT_FOUND_ERROR) }
    }
}
