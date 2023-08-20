package dev.bread.domain.repository

import dev.bread.domain.Review

interface ReviewRepository {
    fun findById(reviewId: Long): Review
    fun findAllByMemberId(memberId: Long): List<Review>
    fun save(review: Review): Long
}
