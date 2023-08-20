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
class ReviewEntity(

    @Column(name = "MEMBER_ID")
    var memberId: Long,

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "REVIEW_MENU",
        joinColumns = [JoinColumn(name = "REVIEW_ID", referencedColumnName = "ID")]
    )
    var reviewMenus: MutableList<ReviewMenuVo>,

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "REVIEW_IMAGE",
        joinColumns = [JoinColumn(name = "REVIEW_ID", referencedColumnName = "ID")]
    )
    var reviewImages: MutableList<ReviewImageEntity>? = null,

    @Embedded
    @Column(name = "MENU_REVIEW")
    var reviewDelivery: ReviewDeliveryVo,

    @Embedded
    var content: ReviewContentVo,

    @Column(name = "VISIBLE_TO_OWNER")
    var visibleToOwner: Boolean,

    @Column(name = "DELETED")
    var deleted: Boolean = false

) : BaseEntity() {

    fun update(reviewMenuVo: ReviewMenuVo, reviewImageEntity: ReviewImageEntity, content: ReviewContentVo) {
        this.reviewMenus.map { it.update(reviewMenuVo) }
        this.reviewImages?.map { it.update(reviewImageEntity) }
    }

    fun rate(): Int {
        return this.content.rate
    }

    fun delete(delete: Boolean) {
        this.deleted = deleted
    }
}
