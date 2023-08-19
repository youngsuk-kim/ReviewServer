package dev.bread.domain

import dev.bread.controller.v1.request.SaveReviewRequest
import dev.bread.domain.implementation.MemberReader
import dev.bread.domain.implementation.ReviewReader
import dev.bread.domain.implementation.ReviewWriter
import dev.bread.storage.repository.MenuRepositoryCustom
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewService(
    private val reviewWriter: ReviewWriter,
    private val reviewReader: ReviewReader,
    private val memberReader: MemberReader,
    private val menuRepositoryCustom: MenuRepositoryCustom
) {

    @Transactional
    fun write(request: SaveReviewRequest): Long {
        val review = reviewWriter.save(request)

        return review.id!!
    }

    @Transactional(readOnly = true)
    fun readOne(reviewId: Long, memberId: Long): ReviewResult {
        val member = memberReader.read(memberId)
        val review = reviewReader.readByMemberId(memberId)
        val menu = menuRepositoryCustom.findRecommend(memberId)
            ?.map { Menu(it.koName, it.enName, it.recommend) }

        return ReviewResult(
            userName = member.name,
            menu = menu,
            reviewCount = review?.count(),
            averageRate = review?.map { it.rate() }?.average(),
            storeRate = review?.find { it.id == reviewId }?.rate()
        )
    }
}
