package dev.bread.presenter.v1

import dev.bread.application.Menu
import dev.bread.application.ReviewResult
import dev.bread.application.ReviewService
import dev.bread.doc.RestDocsTest
import dev.bread.doc.RestDocsUtils.requestPreprocessor
import dev.bread.doc.RestDocsUtils.responsePreprocessor
import dev.bread.presenter.v1.request.SaveReviewRequest
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

    private lateinit var service: ReviewService
    private lateinit var controller: ReviewController

    @BeforeEach
    fun setUp() {
        service = mockk()
        controller = ReviewController(service)
        mockMvc = mockController(controller)
    }

    @Test
    fun 리뷰작성() {
        every { service.write(any()) } returns 1L

        given()
            .contentType(ContentType.JSON)
            .body(
                SaveReviewRequest(
                    1L,
                    true,
                    "배달이 빨라요",
                    1L,
                    listOf(
                        dev.bread.presenter.v1.request.Menu(
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

    @Test
    fun 리뷰하나불러오기() {
        every { service.readOne(1L, 1L) } returns ReviewResult("테스트 유저", listOf(Menu("치킨", "Chicken", false)), 5, 3.0, 4)

        given()
            .contentType(ContentType.JSON)
            .get("/v1/reviews/1/1")
            .then()
            .status(HttpStatus.OK)
            .apply(
                document(
                    "리뷰 한개 불러오기",
                    requestPreprocessor(),
                    responsePreprocessor(),
                    responseFields(
                        fieldWithPath("data.userName").type(JsonFieldType.STRING).description("유저 이름"),
                        fieldWithPath("data.reviewCount").type(JsonFieldType.NUMBER).description("리뷰 갯수"),
                        fieldWithPath("data.menu[0].koName").type(JsonFieldType.STRING).description("메뉴 이름 (한국어)"),
                        fieldWithPath("data.menu[0].enName").type(JsonFieldType.STRING).description("메뉴 이름 (영어)"),
                        fieldWithPath("data.menu[0].recommend").type(JsonFieldType.BOOLEAN).description("유저 메뉴 추천 여부"),
                        fieldWithPath("data.averageRate").type(JsonFieldType.NUMBER).description("유저 리뷰 평균 별점 "),
                        fieldWithPath("data.storeRate").type(JsonFieldType.NUMBER).description("유저가 매긴 상점 별점"),
                        fieldWithPath("error").type(JsonFieldType.NULL).description("에러 메시지"),
                        fieldWithPath("result").type(JsonFieldType.STRING).description("결과 메시지")
                    )
                )
            )
    }
}
