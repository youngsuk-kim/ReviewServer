package dev.bread.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Transient

@Embeddable
class ReviewMenu(

    @Column(name = "RECOMMEND")
    var recommend: Boolean,

    @Column(name = "SECRET_MENU")
    var secretMenu: Boolean,

    @Column(name = "MENU_RATE")
    var menuRate: Int,

    @Column(name = "MENU_ID")
    var menuId: Long,

    @Transient
    var koName: Long? = null,

    @Transient
    var enName: Long? = null,

) {
    fun update(reviewMenuVo: ReviewMenu) {
        this.menuId = reviewMenuVo.menuId
    }
}
