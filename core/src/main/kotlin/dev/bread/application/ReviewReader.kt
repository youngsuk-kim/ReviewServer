package dev.bread.application

import dev.bread.storage.entity.Review
import dev.bread.storage.repository.ReviewRepository
import dev.bread.support.error.CoreException
import dev.bread.support.error.ErrorType
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ReviewReader(
    private val reviewRepository: ReviewRepository
) {
    @Transactional(readOnly = true)
    fun read(reviewId: Long): Review {
        return reviewRepository.findById(reviewId)
            .orElseGet { throw CoreException(ErrorType.NOT_FOUND_ERROR) }
    }

    @Transactional(readOnly = true)
    fun readByMemberId(memberId: Long): List<Review>? {
        return reviewRepository.findAllByMemberId(memberId)
    }

    @Transactional(readOnly = true)
    fun reviewCountByMemberId(memberId: Long): Int {
        return reviewRepository.countByMemberId(memberId)
    }

    @Transactional(readOnly = true)
    fun calculateAverageByMemberId(memberId: Long): Double? {
        val reviews = reviewRepository.findAllByMemberId(memberId)

        return reviews?.map { it.rate() }?.average()
    }
}
