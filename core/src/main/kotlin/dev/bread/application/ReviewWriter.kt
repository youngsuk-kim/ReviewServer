package dev.bread.application

import dev.bread.domain.Review
import dev.bread.domain.ReviewRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class ReviewWriter(
    private val reviewRepository: ReviewRepository
) {

    fun save(review: Review): Long {
        return reviewRepository.save(review)
    }

    fun update(review: Review) {
        reviewRepository.save(review)
    }
}
