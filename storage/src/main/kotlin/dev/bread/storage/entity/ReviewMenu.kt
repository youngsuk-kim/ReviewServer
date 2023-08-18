package dev.bread.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class ReviewMenu(

    @Column(name = "RECOMMEND")
    var recommend: Boolean,

    @Column(name = "SECRET_MENU")
    var secretMenu: Boolean,

    @Column(name = "MENU_RATE")
    var menuRate: Int,

    @Column(name = "MENU_ID")
    var menuId: Long

) {
    fun update(reviewMenu: ReviewMenu) {
        this.menuId = reviewMenu.menuId
    }
}