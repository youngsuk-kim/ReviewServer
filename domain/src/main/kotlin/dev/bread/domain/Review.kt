package dev.bread.domain

data class Review(
    var id: Long? = null,
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
