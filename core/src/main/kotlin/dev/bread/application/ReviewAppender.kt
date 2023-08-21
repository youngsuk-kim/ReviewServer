package dev.bread.application

import dev.bread.storage.entity.Review
import dev.bread.storage.repository.ReviewRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class ReviewAppender(
    private val reviewRepository: ReviewRepository,
    private val reviewFinder: ReviewFinder
) {

    fun save(newReview: NewReview): Review {
        return reviewRepository.save(newReview.toDomain())
    }

    fun update(updateReview: UpdateReview) {
        reviewRepository.save(updateReview.toEntity())
    }

    fun delete(reviewId: Long) {
        val review = reviewFinder.find(reviewId)
        review.delete()

        reviewRepository.save(review)
    }
}
