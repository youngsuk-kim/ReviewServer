package dev.bread.application

import dev.bread.controller.v1.request.SaveMenu
import dev.bread.controller.v1.request.SaveReviewHttpRequest
import dev.bread.controller.v1.request.UpdateMenu
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
class ReviewWriteServiceTest {

    @InjectMockKs
    private lateinit var reviewWriteService: ReviewWriteService

    @MockK
    private lateinit var reviewWriter: ReviewWriter

    @Test
    fun `ReviewWriter write 메소드 호출`() {
        val request = SaveReviewHttpRequest(
            memberId = 1L,
            deliverySatisfied = true,
            deliveryReviewReason = "배달이 빨라요",
            storeId = 1L,
            saveMenus = listOf(SaveMenu(true, true, 1L, 4)),
            reviewText = "맛있어요",
            storeRate = 4,
            visibleToOwner = true
        ).toReview()

        every { reviewWriter.save(request) }.returns(1L)
        reviewWriteService.write(request)

        verify(exactly = 1) { reviewWriter.save(request) }
    }

    @Test
    fun `ReviewWriter update 메소드 호출`() {
        val request = UpdateReviewHttpRequest(
            memberId = 1L,
            reviewText = "맛있어요",
            storeRate = 4,
            visibleToOwner = true,
            reviewId = 1L,
            menu = listOf(UpdateMenu(
                menuId = 1L,
                recommend = true,
                secretMenu = true,
                menuRate = 4
            ))
        ).toReview()

        every { reviewWriter.update(request) }.returns(any())
        reviewWriteService.update(request)

        verify(exactly = 1) { reviewWriter.update(request) }
    }
}