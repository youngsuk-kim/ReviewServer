package dev.bread.provider.v1

import dev.bread.application.ReviewCommandService
import dev.bread.provider.v1.request.ReviewSaveHttpRequest
import dev.bread.provider.v1.request.ReviewUpdateHttpRequest
import dev.bread.support.response.ApiResponse
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewProvider(
    private val reviewCommandService: ReviewCommandService
) {

    @PostMapping("/v1/reviews")
    fun save(
        @Validated @RequestBody
        request: ReviewSaveHttpRequest
    ): ApiResponse<Long?> {
        val id = reviewCommandService.create(request.toNewReview(), request.toFile())

        return ApiResponse.success(id)
    }

    @PutMapping("/v1/reviews")
    fun update(
        @RequestBody
        request: ReviewUpdateHttpRequest
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
