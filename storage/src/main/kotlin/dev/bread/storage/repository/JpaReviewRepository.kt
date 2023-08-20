package dev.bread.storage.repository

import dev.bread.storage.entity.ReviewEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaReviewRepository : JpaRepository<ReviewEntity, Long> {
    fun countByMemberId(memberId: Long): Int
    fun findAllByMemberId(memberId: Long): List<ReviewEntity>?
}
