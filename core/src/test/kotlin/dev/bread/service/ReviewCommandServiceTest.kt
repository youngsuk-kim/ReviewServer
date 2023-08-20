package dev.bread.service

import dev.bread.application.ReviewCommandService
import dev.bread.application.implementation.ReviewAppender
import dev.bread.controller.v1.request.SaveMenuHttpRequest
import dev.bread.controller.v1.request.SaveReviewHttpRequest
import dev.bread.controller.v1.request.UpdateMenuHttpRequest
import dev.bread.controller.v1.request.UpdateReviewHttpRequest
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
        val request = SaveReviewHttpRequest(
            memberId = 1L,
            deliverySatisfied = true,
            deliveryReviewReason = "배달이 빨라요",
            storeId = 1L,
            menus = listOf(SaveMenuHttpRequest(true, true, 1L, 4)),
            reviewText = "맛있어요",
            storeRate = 4,
            visibleToOwner = true
        ).toNewReview()

        every { reviewAppender.save(request) }.returns(1L)
        reviewCommandService.write(request)

        verify(exactly = 1) { reviewAppender.save(request) }
    }

    @Test
    fun `ReviewWriter update 메소드 호출`() {
        val request = UpdateReviewHttpRequest(
            memberId = 1L,
            reviewText = "맛있어요",
            storeRate = 4,
            visibleToOwner = true,
            reviewId = 1L,
            menu = listOf(
                UpdateMenuHttpRequest(
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
