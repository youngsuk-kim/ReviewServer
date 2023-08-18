package dev.bread.presenter.v1

import dev.bread.application.ReviewService
import dev.bread.presenter.v1.request.SaveReviewRequest
import dev.bread.support.response.ApiResponse
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewController(
  private val reviewService: ReviewService
) {

  @PostMapping("/v1/reviews")
  fun save(
    @Validated @RequestBody
    request: SaveReviewRequest
  ): ApiResponse<Long> {
    val id = reviewService.write(request)

    return ApiResponse.success(id)
  }
}