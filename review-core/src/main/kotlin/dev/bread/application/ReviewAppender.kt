package dev.bread.application

import dev.bread.storage.repository.ReviewRepository
import dev.bread.support.Transaction
import org.springframework.stereotype.Component

@Component
class ReviewAppender(
    private val reviewRepository: ReviewRepository
) {

    fun save(newReview: NewReview): Long? {
        val result = Transaction.start {
            reviewRepository.save(newReview.toDomain())
        }

        return result?.id
    }
}
