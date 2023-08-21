package dev.bread.domain

import java.util.Optional

data class Review(
    var reviewId: Long? = null,
    var memberId: Long,
    var reviewMenus: List<ReviewMenu>? = null,
    var reviewImages: List<ReviewImage>? = null,
    var reviewDelivery: ReviewDelivery? = null,
    var content: ReviewContent,
    var visibleToOwner: Boolean,
    var deleted: Boolean = false
) {
    fun rate(): Int {
        return content.rate
    }

    fun delete() {
        this.deleted = true
    }
}
