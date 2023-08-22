package dev.bread.application

import dev.bread.client.FileService
import org.springframework.stereotype.Service
import java.io.File

@Service
class ReviewCommandService(
    private val reviewAppender: ReviewAppender,
    private val reviewUpdater: ReviewUpdater,
    private val reviewRemover: ReviewRemover,
    private val fileService: FileService
) {

    fun create(newReview: NewReview, files: Set<File> = emptySet()): Long? {
        val result = reviewAppender.save(newReview)
        fileService.upload(files)

        return result
    }

    fun update(updateReview: UpdateReview) {
        reviewUpdater.update(updateReview)
    }

    fun delete(reviewId: Long) {
        reviewRemover.delete(reviewId)
    }
}
