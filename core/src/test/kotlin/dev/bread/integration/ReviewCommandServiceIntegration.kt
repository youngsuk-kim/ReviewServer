package dev.bread.integration

import dev.bread.application.NewMenu
import dev.bread.application.NewReview
import dev.bread.application.NewReviewContent
import dev.bread.application.ReviewAppender
import dev.bread.application.ReviewCommandService
import dev.bread.application.UpdateContent
import dev.bread.application.UpdateMenu
import dev.bread.application.UpdateReview
import dev.bread.domain.repository.ReviewRepository
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class ReviewCommandServiceIntegration {

    @Autowired
    private lateinit var reviewCommandService: ReviewCommandService

    @Autowired
    private lateinit var reviewRepository: ReviewRepository

    @Test
    fun `리뷰 작성`() {
        val reviewId = reviewCommandService.create(
            NewReview(
                memberId = 1L,
                reviewMenus = listOf(
                    NewMenu(
                        recommend = true,
                        secretMenu = true,
                        menuRate = 3,
                        menuId = 4)
                ),
                visibleToOwner = true,
                content = NewReviewContent(rate = 1, text =  "맛있어요")
            )
        )

        assertThat(reviewId).isEqualTo(1L)
    }

    @Test
    fun `리뷰 업데이트`() {
        val reviewId = reviewCommandService.create(
            NewReview(
                memberId = 1L,
                reviewMenus = listOf(
                    NewMenu(
                        recommend = true,
                        secretMenu = true,
                        menuRate = 3,
                        menuId = 4
                    )
                ),
                visibleToOwner = true,
                content = NewReviewContent(rate = 1, text = "맛있어요")
            )
        )

        println(reviewId.id!!)

        reviewCommandService.update(
            UpdateReview(
                reviewId = reviewId.id!!,
                memberId = 3L,
                reviewMenus = mutableListOf(
                    UpdateMenu(
                        recommend = true,
                        secretMenu = true,
                        menuRate = 3,
                        menuId = 4
                    )
                ),
                visibleToOwner = true,
                content = UpdateContent(rate = 1, text = "맛있어요")
            )
        )
    }

}
