package dev.bread.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class ReviewImage(

    @Column(name = "IMAGE_URL")
    var imageUrl: String
) {
    fun update(reviewImage: ReviewImage) {
        this.imageUrl = reviewImage.imageUrl
    }
}
