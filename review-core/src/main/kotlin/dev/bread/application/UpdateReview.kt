package dev.bread.application

data class UpdateReview(
    val reviewId: Long,
    val memberId: Long,
    val reviewMenus: MutableList<UpdateMenu>,
    val content: UpdateContent,
    val visibleOwner: Boolean
)
