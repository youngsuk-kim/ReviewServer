package dev.bread.application

import dev.bread.presenter.v1.request.SaveReviewRequest
import dev.bread.storage.data.ReviewMenuResult
import dev.bread.storage.repository.MenuRepositoryCustom
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewService(
    private val reviewWriter: ReviewWriter,
    private val reviewReader: ReviewReader,
    private val memberReader: MemberReader,
    private val menuReader: MenuReader,
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
        val reviewCount = reviewReader.reviewCountByMemberId(memberId)
        val reviewAverageRate = reviewReader.calculateAverageByMemberId(memberId)
        val review = reviewReader.read(reviewId)

        val menu = menuRepositoryCustom.findRecommend(memberId)
            ?.map { Menu(it.koName, it.enName, it.recommend) }

        return ReviewResult(member.name, menu!!, reviewCount, reviewAverageRate!!, review.rate())
    }
}
