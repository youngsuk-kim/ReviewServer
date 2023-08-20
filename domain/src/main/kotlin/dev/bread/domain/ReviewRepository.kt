package dev.bread.domain

interface ReviewRepository {
    fun findById(reviewId: Long): Review?
    fun findAllByMemberId(memberId: Long): List<Review>?
    fun save(review: Review): Long
}
