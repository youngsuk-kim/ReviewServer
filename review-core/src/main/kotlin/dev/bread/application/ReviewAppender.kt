package dev.bread.application

import dev.bread.client.ImageUploader
import dev.bread.storage.entity.Review
import dev.bread.storage.repository.ReviewRepository
import dev.bread.support.TransactionAction
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ReviewAppender(
    private val reviewRepository: ReviewRepository
) {

    fun save(newReview: NewReview): Long {
        return reviewRepository.save(newReview.toDomain())
            .id!!
    }

}
