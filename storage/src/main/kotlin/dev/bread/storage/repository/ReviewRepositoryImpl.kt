package dev.bread.storage.repository

import dev.bread.domain.Review
import dev.bread.domain.ReviewRepository
import dev.bread.storage.mapper.toDomain
import dev.bread.storage.mapper.toEntity
import org.springframework.stereotype.Repository

@Repository
class ReviewRepositoryImpl(
    private val jpaReviewRepository: JpaReviewRepository
) : ReviewRepository {
    override fun findById(reviewId: Long): Review {
        val review = jpaReviewRepository.findById(reviewId)
            .orElseThrow { throw NoSuchElementException("Review not found error occurred.") }

        return review.toDomain()
    }

    override fun findAllByMemberId(memberId: Long): List<Review>? {
        TODO("Not yet implemented")
    }

    override fun save(review: Review): Review {
        val reviewEntity = jpaReviewRepository.save(review.toEntity())
        return reviewEntity.toDomain()
    }
}
