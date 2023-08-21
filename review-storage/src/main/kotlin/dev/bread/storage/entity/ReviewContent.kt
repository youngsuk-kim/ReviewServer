package dev.bread.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

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
