package dev.bread.controller.v1.request

import dev.bread.application.WriteOneReviewCommand
import dev.bread.domain.ReviewContent
import dev.bread.domain.ReviewMenu
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class SaveReviewHttpRequest(

    @NotNull
    val memberId: Long,

    val deliverySatisfied: Boolean,

    @Max(value = 5000)
    val deliveryReviewReason: String?,

    @NotNull
    val storeId: Long,

    @NotNull
    val saveMenus: List<SaveMenu>,

    @Max(value = 5000)
    val reviewText: String,

    @Min(value = 5)
    @Positive
    val storeRate: Int,

    val visibleToOwner: Boolean
) {
    fun toCommand(): WriteOneReviewCommand {
        return WriteOneReviewCommand(
            memberId = this.memberId,

            reviewMenus = this.saveMenus.map {
                ReviewMenu(
                    recommend = it.recommend,
                    secretMenu = it.secretMenu,
                    menuRate = it.menuRate,
                    menuId = it.menuId
                )
            }.toMutableList(),

            content = ReviewContent(
                rate = this.storeRate,
                text = this.reviewText
            ),

            visibleToOwner = this.visibleToOwner
        )
    }
}

data class SaveMenu(
    val recommend: Boolean,
    val secretMenu: Boolean,
    @NotNull
    val menuId: Long,
    @Min(value = 5)
    @Positive
    val menuRate: Int
)
