package dev.bread.storage.repository

import dev.bread.domain.Review
import dev.bread.domain.repository.ReviewRepository
import dev.bread.storage.mapper.toDomain
import dev.bread.storage.mapper.toEntity
import org.springframework.stereotype.Repository

@Repository
class ReviewRepositoryImpl(
    private val jpaReviewRepository: JpaReviewRepository
) : ReviewRepository {
    override fun findById(reviewId: Long): Review {
        return jpaReviewRepository.findById(reviewId)
            .orElseThrow { throw NoSuchElementException("Review not found error occurred.") }
            .toDomain()
    }

    override fun findAllByMemberId(memberId: Long): List<Review> {
        return jpaReviewRepository.findAllByMemberId(memberId)
            ?.map { it.toDomain() } ?: throw NoSuchElementException("Review not found error occurred.")
    }

    override fun save(review: Review): Review {
        return jpaReviewRepository.save(review.toEntity())
            .toDomain()
    }
}
