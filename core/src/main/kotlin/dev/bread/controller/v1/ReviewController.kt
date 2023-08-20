package dev.bread.controller.v1

import dev.bread.application.ReviewReadService
import dev.bread.application.ReviewWriteService
import dev.bread.controller.v1.request.SaveReviewHttpRequest
import dev.bread.controller.v1.request.UpdateReviewHttpRequest
import dev.bread.controller.v1.response.GetOneReviewHttpResponse
import dev.bread.support.response.ApiResponse
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewController(
    private val reviewWriteService: ReviewWriteService,
    private val reviewReadService: ReviewReadService
) {

    @PostMapping("/v1/reviews")
    fun save(
        @Validated @RequestBody
        request: SaveReviewHttpRequest
    ): ApiResponse<Long> {
        val id = reviewWriteService.write(request.toCommand())

        return ApiResponse.success(id!!)
    }

    @GetMapping("/v1/reviews/{reviewId}")
    fun getOne(
        @PathVariable reviewId: Long,
        @RequestParam memberId: Long
    ): ApiResponse<GetOneReviewHttpResponse> {
        return ApiResponse.success(
            GetOneReviewHttpResponse.from(reviewReadService.readOne(reviewId, memberId))
        )
    }

    @PutMapping("/v1/reviews")
    fun update(
        @RequestBody
        request: UpdateReviewHttpRequest
    ): ApiResponse<Unit> {
        return ApiResponse.success(
            reviewWriteService.update(request.toCommand())
        )
    }
}
