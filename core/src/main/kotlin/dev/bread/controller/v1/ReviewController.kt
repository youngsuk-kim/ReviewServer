package dev.bread.controller.v1

import dev.bread.application.ReviewCommandService
import dev.bread.application.ReviewQueryService
import dev.bread.controller.v1.request.SaveReviewHttpRequest
import dev.bread.controller.v1.request.UpdateReviewHttpRequest
import dev.bread.support.response.ApiResponse
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewController(
    private val reviewCommandService: ReviewCommandService,
    private val reviewQueryService: ReviewQueryService
) {

    @PostMapping("/v1/reviews")
    fun save(
        @Validated @RequestBody
        request: SaveReviewHttpRequest
    ): ApiResponse<Long> {
        val id = reviewCommandService.write(request.toNewReview())

        return ApiResponse.success(id)
    }

    @PutMapping("/v1/reviews")
    fun update(
        @RequestBody
        request: UpdateReviewHttpRequest
    ): ApiResponse<Unit> {
        return ApiResponse.success(
            reviewCommandService.update(request.toUpdateReview())
        )
    }

    @DeleteMapping("/v1/reviews/{reviewId}")
    fun delete(
        @PathVariable reviewId: Long
    ): ApiResponse<Unit> {
        return ApiResponse.success(
            reviewCommandService.delete(reviewId)
        )
    }
}
