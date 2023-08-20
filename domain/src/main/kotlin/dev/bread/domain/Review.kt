package dev.bread.domain

data class Review(
    var reviewId: Long? = null,
    var memberId: Long,
    var reviewMenus: MutableList<ReviewMenu>,
    var reviewImages: MutableList<ReviewImage>? = null,
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
