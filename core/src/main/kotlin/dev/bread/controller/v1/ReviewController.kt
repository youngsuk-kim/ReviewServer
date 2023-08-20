package dev.bread.controller.v1

import dev.bread.application.ReviewReadService
import dev.bread.application.ReviewWriteService
import dev.bread.controller.v1.request.SaveReviewRequest
import dev.bread.controller.v1.response.GetOneReviewResponse
import dev.bread.support.response.ApiResponse
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewController(
    private val reviewWriteService: ReviewWriteService,
    private val reviewReadService: ReviewReadService
) {

    @PostMapping("/v1/reviews")
    fun save(
        @Validated @RequestBody
        request: SaveReviewRequest
    ): ApiResponse<Long> {
        val id = reviewWriteService.write(request)

        return ApiResponse.success(id)
    }

    @GetMapping("/v1/reviews/{memberId}/{reviewId}")
    fun getOne(
        @PathVariable memberId: Long,
        @PathVariable reviewId: Long
    ): ApiResponse<GetOneReviewResponse> {
        return ApiResponse.success(
            GetOneReviewResponse.convert(
                reviewReadService.readOne(reviewId, memberId)
            )
        )
    }
}
