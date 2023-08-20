package dev.bread.domain

data class Review(
    val reviewId: Long? = null,
    val memberId: Long,
    val reviewMenus: MutableList<ReviewMenu>,
    val reviewImages: MutableList<ReviewImage>? = null,
    val reviewDelivery: ReviewDelivery,
    val content: ReviewContent,
    val visibleToOwner: Boolean,
    val deleted: Boolean = false
) {
    fun rate(): Int {
        return content.rate
    }
}
