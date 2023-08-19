package dev.bread.storage.repository

import dev.bread.storage.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Long> {
    fun countByMemberId(memberId: Long): Int
    fun findAllByMemberId(memberId: Long): List<Review>?
}
