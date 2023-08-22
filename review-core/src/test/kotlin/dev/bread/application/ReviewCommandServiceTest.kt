package dev.bread.application

import dev.bread.storage.entity.ReviewContent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("local")
class ReviewCommandServiceTest {

    @Autowired
    private lateinit var service: ReviewCommandService

    @Autowired
    private lateinit var reviewFinder: ReviewFinder

    @Test
    fun `리뷰가 저장된다`() {
        val newReview = NewReview(
            memberId = 1L,
            reviewMenus = listOf(
                NewMenu(
                    recommend = true,
                    secretMenu = true,
                    menuId = 1L,
                    menuRate = 4
                )
            ),
            NewReviewContent(
                rate = 3,
                text = "그럭 저럭 먹을만해요"
            ),
            visibleOwner = true
        )

        val id = service.create(newReview)
        val foundReview = reviewFinder.find(id!!)

        assertThat(foundReview.content).isEqualTo(ReviewContent(3, "그럭 저럭 먹을만해요"))
    }

    @Test
    fun `리뷰가 업데이트 된다`() {
        val newReview = NewReview(
            memberId = 1L,
            reviewMenus = listOf(
                NewMenu(
                    recommend = true,
                    secretMenu = true,
                    menuId = 1L,
                    menuRate = 4
                )
            ),
            NewReviewContent(
                rate = 3,
                text = "그럭 저럭 먹을만해요"
            ),
            visibleOwner = true
        )

        val id = service.create(newReview)

        val updateReview = UpdateReview(
            reviewId = 1L,
            memberId = 1L,
            reviewMenus = mutableListOf(
                UpdateMenu(
                    recommend = true,
                    secretMenu = true,
                    menuId = 1L,
                    menuRate = 4
                )
            ),
            UpdateContent(
                rate = 2,
                text = "그럭 저럭 먹을만해요"
            ),
            visibleOwner = true
        )

        service.update(updateReview)
        val foundReview = reviewFinder.find(id!!)

        assertThat(foundReview.content.rate).isEqualTo(2)
    }

    @Test
    fun `리뷰가 삭제된다`() {
        val newReview = NewReview(
            memberId = 1L,
            reviewMenus = listOf(
                NewMenu(
                    recommend = true,
                    secretMenu = true,
                    menuId = 1L,
                    menuRate = 4
                )
            ),
            NewReviewContent(
                rate = 3,
                text = "그럭 저럭 먹을만해요"
            ),
            visibleOwner = true
        )

        val id = service.create(newReview)

        service.delete(id!!)
        val foundReview = reviewFinder.find(id)

        assertThat(foundReview.isDeleted).isEqualTo(true)
    }
}
