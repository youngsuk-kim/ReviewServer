package dev.bread.application

import dev.bread.domain.ReviewRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class ReviewWriter(
    private val reviewRepository: ReviewRepository
) {

    fun save(command: WriteOneReviewCommand): Long {
        return reviewRepository.save(command.toDomain())
    }

    fun update(command: UpdateOneReviewCommand) {
        reviewRepository.save(command.toDomain())
    }
}
