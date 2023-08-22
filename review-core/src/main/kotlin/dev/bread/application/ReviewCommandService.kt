package dev.bread.application

import dev.bread.client.FileService
import dev.bread.client.ImageUploader
import dev.bread.storage.entity.Review
import dev.bread.support.TransactionAction
import dev.bread.support.TransactionHandler
import dev.bread.support.TransactionTemplateHandler
import org.springframework.stereotype.Service
import org.springframework.transaction.support.TransactionCallback
import java.io.File

@Service
class ReviewCommandService(
    private val reviewAppender: ReviewAppender,
    private val reviewUpdater: ReviewUpdater,
    private val reviewRemover: ReviewRemover,
    private val fileService: FileService,
    private val transactionHandler: TransactionHandler<Long>
) {

    fun create(newReview: NewReview, files: Set<File> = emptySet()): Long? {

        val id = transactionHandler.execute {
            reviewAppender.save(newReview)
        }

        fileService.upload(files)

        return id
    }

    fun update(updateReview: UpdateReview) {
        reviewUpdater.update(updateReview)
    }

    fun delete(reviewId: Long) {
        reviewRemover.delete(reviewId)
    }
}
