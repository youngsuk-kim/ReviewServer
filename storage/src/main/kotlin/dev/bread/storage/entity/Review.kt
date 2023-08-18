package dev.bread.storage.entity

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
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
    var reviewMenus: MutableList<ReviewMenu>,

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "REVIEW_IMAGE",
        joinColumns = [JoinColumn(name = "REVIEW_ID", referencedColumnName = "ID")]
    )
    var reviewImages: MutableList<ReviewImage>? = null,

    @Embedded
    @Column(name = "MENU_REVIEW")
    var reviewDelivery: ReviewDelivery,

    @Embedded
    var content: ReviewContent,

    @Column(name = "VISIBLE_TO_OWNER")
    var visibleToOwner: Boolean,

    @Column(name = "DELETED")
    var deleted: Boolean = false

) : BaseEntity() {

    fun update(reviewMenu: ReviewMenu, reviewImage: ReviewImage, content: ReviewContent) {
        this.reviewMenus.map { it.update(reviewMenu) }
        this.reviewImages?.map { it.update(reviewImage) }
    }

    fun delete(delete: Boolean) {
        this.deleted = deleted
    }
}
