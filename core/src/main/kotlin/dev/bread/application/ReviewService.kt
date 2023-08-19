package dev.bread.application

import dev.bread.presenter.v1.request.SaveReviewRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewService(
    private val reviewWriter: ReviewWriter,
    private val reviewReader: ReviewReader,
    private val memberReader: MemberReader,
    private val menuReader: MenuReader
) {

    @Transactional
    fun write(request: SaveReviewRequest): Long {
        val review = reviewWriter.save(request)

        return review.id!!
    }

    @Transactional(readOnly = true)
    fun readOne(reviewId: Long, memberId: Long) {
        val review = reviewReader.read(reviewId)
        val reviewCount = reviewReader.reviewCountByMemberId(memberId)
        val reviewAverage = reviewReader.calculateAverageByMemberId(memberId)
        val member = memberReader.read(memberId)
        val menus = menuReader.read(review.reviewMenus.map { it.menuId })

//        ReviewResult(member.name, , reviewCount,reviewAverage!!,  review.rate())
    }
}
