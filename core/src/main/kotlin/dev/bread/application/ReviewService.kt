package dev.bread.application

import dev.bread.presenter.v1.request.SaveReviewRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewService(
    private val reviewWriter: ReviewWriter
) {

    @Transactional
    fun write(request: SaveReviewRequest): Long {
        val review = reviewWriter.save(request)

        return review.id!!
    }
}
