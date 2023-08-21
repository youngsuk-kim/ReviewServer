package dev.bread.application

import dev.bread.application.NewReview
import dev.bread.application.UpdateReview
import dev.bread.domain.Review
import dev.bread.domain.repository.ReviewRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class ReviewAppender(
    private val reviewRepository: ReviewRepository
) {

    fun save(newReview: NewReview): Review {
        return reviewRepository.save(newReview.toDomain())
    }

    fun update(updateReview: UpdateReview) {
        val review = reviewRepository.findById(updateReview.reviewId)
        review.update()

        reviewRepository.save(review)
    }

    fun delete(reviewId: Long) {
        val review = reviewRepository.findById(reviewId)
        review.delete()

        reviewRepository.save(review)
    }
}
