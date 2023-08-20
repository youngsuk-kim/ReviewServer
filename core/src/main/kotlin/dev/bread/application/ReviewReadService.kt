package dev.bread.application

import dev.bread.application.implementation.MemberReader
import dev.bread.application.implementation.MenuReader
import dev.bread.application.implementation.ReviewReader
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewReadService(
    private val reviewReader: ReviewReader,
    private val memberReader: MemberReader,
    private val menuReader: MenuReader
) {

    @Transactional(readOnly = true)
    fun readOne(reviewId: Long, memberId: Long): ReviewResult {
        val member = memberReader.read(memberId)
        val review = reviewReader.readByMemberId(memberId)

        return ReviewResult(
            userName = member?.name,
            menu = menuReader.findRecommendMenuByMemberId(memberId),
            reviewCount = review?.count(),
            averageRate = review?.map { it.rate() }?.average(),
            storeRate = review?.find { it.reviewId == reviewId }?.rate()
        )
    }
}
