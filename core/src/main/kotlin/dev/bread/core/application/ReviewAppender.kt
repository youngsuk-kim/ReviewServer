package dev.bread.core.application

import dev.bread.storage.repository.ReviewRepository
import dev.bread.storage.entity.Review
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
        val review = updateReview.toEntity()
        reviewRepository.save(review)

        review.update(review.reviewMenus, review.content)
    }

    fun delete(reviewId: Long) {
        val review = reviewFinder.find(reviewId)

        review.delete()
    }
}
