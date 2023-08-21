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
    var reviewDelivery: ReviewDelivery? = null,

    @Embedded
    var content: ReviewContent,

    @Column(name = "VISIBLE_OWNER")
    var isVisibleToOwner: Boolean,

    @Column(name = "DELETED")
    var isDeleted: Boolean = false

) : BaseEntitiy() {

    fun update(reviewMenus: MutableList<ReviewMenu>, content: ReviewContent) {
        this.reviewMenus = reviewMenus
        this.content = content
    }

    fun rate(): Int {
        return this.content.rate
    }

    fun delete() {
        this.isDeleted = true
    }
}
