package dev.bread.core.service

import dev.bread.core.application.ReviewAppender
import dev.bread.core.application.ReviewCommandService
import dev.bread.core.provider.v1.request.ReviewMenuSaveHttpRequest
import dev.bread.core.provider.v1.request.ReviewSaveHttpRequest
import dev.bread.core.provider.v1.request.ReviewUpdateHttpRequest
import dev.bread.core.provider.v1.request.ReviewUpdateMenuHttpRequest
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any

@ExtendWith(MockKExtension::class)
class ReviewCommandServiceTest {

    @InjectMockKs
    private lateinit var reviewCommandService: ReviewCommandService

    @MockK
    private lateinit var reviewAppender: ReviewAppender

    @Test
    fun `ReviewWriter write 메소드 호출`() {
        val request = ReviewSaveHttpRequest(
            memberId = 1L,
            deliverySatisfied = true,
            deliveryReviewReason = "배달이 빨라요",
            storeId = 1L,
            menus = listOf(ReviewMenuSaveHttpRequest(true, true, 1L, 4)),
            reviewText = "맛있어요",
            storeRate = 4,
            visibleOwner = true
        ).toNewReview()

        every { reviewAppender.save(request) }.returns(any())
        reviewCommandService.create(request)

        verify(exactly = 1) { reviewAppender.save(request) }
    }

    @Test
    fun `ReviewWriter update 메소드 호출`() {
        val request = ReviewUpdateHttpRequest(
            memberId = 1L,
            reviewText = "맛있어요",
            storeRate = 4,
            visibleToOwner = true,
            reviewId = 1L,
            menu = listOf(
                ReviewUpdateMenuHttpRequest(
                    menuId = 1L,
                    recommend = true,
                    secretMenu = true,
                    menuRate = 4
                )
            )
        ).toUpdateReview()

        every { reviewAppender.update(request) }.returns(any())
        reviewCommandService.update(request)

        verify(exactly = 1) { reviewAppender.update(request) }
    }
}
