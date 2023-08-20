package dev.bread.application

import dev.bread.domain.Review
import org.springframework.stereotype.Service

@Service
class ReviewWriteService(
    private val reviewWriter: ReviewWriter
) {

    fun write(review: Review): Long? {
        return reviewWriter.save(review)
    }

    fun update(review: Review) {
        reviewWriter.update(review)
    }
}
