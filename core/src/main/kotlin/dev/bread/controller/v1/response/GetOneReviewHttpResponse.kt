package dev.bread.controller.v1.response

import dev.bread.application.ReadOneReviewCommand

data class GetOneReviewHttpResponse(
    val userName: String,
    val menu: List<Menu>?,
    val reviewCount: Int?,
    val averageRate: Double?,
    val storeRate: Int?
) {
    companion object {
        fun from(command: ReadOneReviewCommand): GetOneReviewHttpResponse {
            return GetOneReviewHttpResponse(
                userName = command.userName!!,
                menu = command.menus?.map { Menu(it.koName, it.enName, it.recommend) },
                reviewCount = command.reviewCount,
                averageRate = command.averageRate,
                storeRate = command.storeRate
            )
        }
    }
}

data class Menu(
    val koName: String,
    val enName: String,
    val recommend: Boolean
)
