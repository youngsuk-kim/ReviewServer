package dev.bread.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class ReviewImageEntity(

    @Column(name = "IMAGE_URL")
    var imageUrl: String
) {
    fun update(reviewImageEntity: ReviewImageEntity) {
        this.imageUrl = reviewImageEntity.imageUrl
    }
}
