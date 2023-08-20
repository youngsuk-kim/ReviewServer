package dev.bread.application

import org.springframework.stereotype.Service

@Service
class ReviewWriteService(
    private val reviewWriter: ReviewWriter
) {

    fun write(command: WriteOneReviewCommand): Long? {
        return reviewWriter.save(command)
    }

    fun update(command: UpdateOneReviewCommand) {
        reviewWriter.update(command)
    }
}
