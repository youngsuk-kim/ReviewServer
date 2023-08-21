package dev.bread.integration

import dev.bread.application.NewMenu
import dev.bread.application.NewReview
import dev.bread.application.NewReviewContent
import dev.bread.application.ReviewCommandService
import dev.bread.application.UpdateContent
import dev.bread.application.UpdateMenu
import dev.bread.application.UpdateReview
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class ReviewCommandServiceIntegration {

    @Autowired
    private lateinit var reviewCommandService: ReviewCommandService

    @Test
    fun `리뷰 작성`() {
        reviewCommandService.create(
            NewReview(
                memberId = 1L,
                reviewMenus = listOf(NewMenu(true, true, 3, 4)),
                visibleToOwner = true,
                content = NewReviewContent(1, "맛있어요")
            )
        )
    }

}
