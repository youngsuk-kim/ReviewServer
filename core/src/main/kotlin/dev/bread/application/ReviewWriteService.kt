package dev.bread.application

import dev.bread.application.implementation.ReviewWriter
import dev.bread.controller.v1.request.SaveReviewRequest
import dev.bread.controller.v1.request.UpdateReviewRequest
import org.springframework.stereotype.Service

@Service
class ReviewWriteService(
    private val reviewWriter: ReviewWriter
) {

    fun write(request: SaveReviewRequest): Long? {
        return reviewWriter.save(request)
    }

    fun update(request: UpdateReviewRequest) {
        reviewWriter.update(request)
    }
}
