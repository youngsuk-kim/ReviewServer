package dev.bread.core.controller.v1

import dev.bread.core.application.ReviewCommandService
import dev.bread.core.provider.v1.ReviewProvider
import dev.bread.core.provider.v1.request.ReviewMenuSaveHttpRequest
import dev.bread.core.provider.v1.request.ReviewSaveHttpRequest
import dev.bread.doc.RestDocsTest
import dev.bread.doc.RestDocsUtils.requestPreprocessor
import dev.bread.doc.RestDocsUtils.responsePreprocessor
import io.mockk.every
import io.mockk.mockk
import io.restassured.http.ContentType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.springframework.http.HttpStatus
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields

class ReviewProviderTest : RestDocsTest() {

    private lateinit var reviewCommandService: ReviewCommandService
    private lateinit var controller: ReviewProvider

    @BeforeEach
    fun setUp() {
        reviewCommandService = mockk()
        controller = ReviewProvider(reviewCommandService)
        mockMvc = mockController(controller)
    }

    @Test
    fun 리뷰작성() {
        every { reviewCommandService.create(any()) } returns any()

        given()
            .contentType(ContentType.JSON)
            .body(
                ReviewSaveHttpRequest(
                    1L,
                    true,
                    "배달이 빨라요",
                    1L,
                    listOf(
                        ReviewMenuSaveHttpRequest(
                            true,
                            true,
                            1L,
                            5
                        )
                    ),
                    "맛있어요",
                    4,
                    true
                )
            )
            .post("/v1/reviews")
            .then()
            .status(HttpStatus.OK)
            .apply(
                document(
                    "리뷰 작성",
                    requestPreprocessor(),
                    responsePreprocessor(),
                    responseFields(
                        fieldWithPath("data").type(JsonFieldType.NUMBER).description("리뷰 아이디"),
                        fieldWithPath("result").type(JsonFieldType.STRING).description("결과"),
                        fieldWithPath("error").type(JsonFieldType.NULL).description("에러")
                    )
                )
            )
    }
}
