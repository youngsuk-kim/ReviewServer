package dev.bread.application

import dev.bread.storage.entity.Review
import dev.bread.storage.repository.ReviewRepository
import dev.bread.support.Transaction
import dev.bread.support.error.CoreException
import dev.bread.support.error.ErrorType
import org.springframework.stereotype.Component
import org.springframework.transaction.support.TransactionCallback

@Component
class ReviewFinder(
    private val reviewRepository: ReviewRepository
) {

    fun find(reviewId: Long): Review {
        val result = Transaction.start { TransactionCallback { it.setRollbackOnly() } }
            .run { reviewRepository.findById(reviewId) }

        return result.orElseThrow {
            throw CoreException(ErrorType.NOT_FOUND_ERROR)
        }
    }
}
