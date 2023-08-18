package dev.bread.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class ReviewDelivery(

    @Column(name = "SATISFIED")
    var satisfied: Boolean,

    @Column(name = "REASON", unique = true)
    var reason: String?
) {

    fun satisfied(satisfied: Boolean) {
        this.satisfied = satisfied
    }
}
