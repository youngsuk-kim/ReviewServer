package dev.bread.storage.mapper

import dev.bread.domain.Review
import dev.bread.domain.ReviewContent
import dev.bread.domain.ReviewDelivery
import dev.bread.domain.ReviewImage
import dev.bread.domain.ReviewMenu
import dev.bread.storage.entity.ReviewContentVo
import dev.bread.storage.entity.ReviewDeliveryVo
import dev.bread.storage.entity.ReviewEntity
import dev.bread.storage.entity.ReviewImageEntity
import dev.bread.storage.entity.ReviewMenuVo

fun Review.toEntity(): ReviewEntity {
    return ReviewEntity(
        memberId = this.memberId,
        reviewMenus = this.reviewMenus.map { ReviewMenuVo(recommend = it.recommend, secretMenu = it.secretMenu, menuRate = it.menuRate, menuId = it.menuId) }.toMutableList(),
        reviewImages = this.reviewImages?.map { ReviewImageEntity(imageUrl = it.imageUrl) }?.toMutableList(),
        reviewDelivery = ReviewDeliveryVo(satisfied = this.reviewDelivery!!.satisfied, reason = this.reviewDelivery!!.reason),
        content = ReviewContentVo(rate = this.content.rate, text = this.content.text),
        visibleToOwner = this.visibleToOwner,
        deleted = this.deleted
    )
}

fun ReviewEntity.toDomain(): Review {
    return Review(
        reviewId = this.id!!,
        memberId = this.memberId,
        reviewMenus = this.reviewMenus.map { ReviewMenu(recommend = it.recommend, secretMenu = it.secretMenu, menuRate = it.menuRate, menuId = it.menuId) }.toMutableList(),
        reviewImages = this.reviewImages?.map { ReviewImage(imageUrl = it.imageUrl) }?.toMutableList(),
        reviewDelivery = ReviewDelivery(satisfied = this.reviewDelivery.satisfied, reason = this.reviewDelivery.reason),
        content = ReviewContent(rate = this.content.rate, text = this.content.text),
        visibleToOwner = this.visibleToOwner,
        deleted = this.deleted
    )
}
