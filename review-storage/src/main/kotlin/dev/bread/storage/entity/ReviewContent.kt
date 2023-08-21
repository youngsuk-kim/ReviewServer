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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ReviewContent

        if (rate != other.rate) return false
        if (text != other.text) return false

        return true
    }

    override fun hashCode(): Int {
        var result = rate
        result = 31 * result + text.hashCode()
        return result
    }
}
