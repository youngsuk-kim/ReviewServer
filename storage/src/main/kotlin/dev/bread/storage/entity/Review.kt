package dev.bread.storage.entity

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table

@Entity
@Table(name = "REVIEW")
class Review(

    @Column(name = "MEMBER_ID")
    var memberId: Long,

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "REVIEW_MENU",
        joinColumns = [JoinColumn(name = "REVIEW_ID", referencedColumnName = "ID")]
    )
    var menuReviews: MutableList<MenuReview>,

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "REVIEW_IMAGE",
        joinColumns = [JoinColumn(name = "REVIEW_ID", referencedColumnName = "ID")]
    )
    var reviewImages: MutableList<ReviewImage>? = null,

    @Embedded
    @Column(name = "MENU_REVIEW")
    var deliveryReview: DeliveryReview,

    @Embedded
    var content: ReviewContent,

    @Column(name = "VISIBLE_TO_OWNER")
    var visibleToOwner: Boolean,

    @Column(name = "DELETED")
    var deleted: Boolean = false

) : BaseEntity() {

    fun update(menuReview: MenuReview, reviewImage: ReviewImage, content: ReviewContent) {
        this.menuReviews.map { it.update(menuReview) }
        this.reviewImages?.map { it.update(reviewImage) }
    }

    fun delete(delete: Boolean) {
        this.deleted = deleted
    }
}

@Embeddable
class ReviewContent(

    @Column(name = "RATE")
    var rate: Int,

    @Column(name = "TEXT")
    var text: String

) {
    fun update(rate: Int, text: String) {
        this.rate = rate
        this.text = text
    }
}
