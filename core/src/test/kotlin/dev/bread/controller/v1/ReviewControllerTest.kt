package dev.bread.controller.v1

import dev.bread.application.ReviewCommandService
import dev.bread.application.ReviewQueryService
import dev.bread.controller.v1.request.SaveMenuHttpRequest
import dev.bread.controller.v1.request.SaveReviewHttpRequest
import dev.bread.doc.RestDocsTest
import dev.bread.doc.RestDocsUtils.requestPreprocessor
import dev.bread.doc.RestDocsUtils.responsePreprocessor
import io.mockk.every
import io.mockk.mockk
import io.restassured.http.ContentType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields

class ReviewControllerTest : RestDocsTest() {

    private lateinit var reviewCommandService: ReviewCommandService
    private lateinit var reviewQueryService: ReviewQueryService
    private lateinit var controller: ReviewController

    @BeforeEach
    fun setUp() {
        reviewCommandService = mockk()
        controller = ReviewController(reviewCommandService, reviewQueryService)
        mockMvc = mockController(controller)
    }

    @Test
    fun 리뷰작성() {
        every { reviewCommandService.write(any()) } returns 1L

        given()
            .contentType(ContentType.JSON)
            .body(
                SaveReviewHttpRequest(
                    1L,
                    true,
                    "배달이 빨라요",
                    1L,
                    listOf(
                        SaveMenuHttpRequest(
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
