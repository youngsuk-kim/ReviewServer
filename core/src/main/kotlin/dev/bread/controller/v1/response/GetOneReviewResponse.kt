package dev.bread.controller.v1.response

import dev.bread.domain.ReviewResult

data class GetOneReviewResponse(
    val userName: String,
    val menu: List<Menu>?,
    val reviewCount: Int?,
    val averageRate: Double?,
    val storeRate: Int?
) {
    companion object {
        fun convert(result: ReviewResult): GetOneReviewResponse {
            return GetOneReviewResponse(
                userName = result.userName,
                menu = result.menu?.map { Menu(it.koName, it.enName, it.recommend) },
                reviewCount = result.reviewCount,
                averageRate = result.averageRate,
                storeRate = result.storeRate
            )
        }
    }
}

data class Menu(
    val koName: String,
    val enName: String,
    val recommend: Boolean
)
