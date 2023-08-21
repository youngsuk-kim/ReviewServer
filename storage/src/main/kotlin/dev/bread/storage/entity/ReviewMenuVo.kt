package dev.bread.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Transient

@Embeddable
class ReviewMenuVo(

    @Column(name = "RECOMMEND")
    var recommend: Boolean,

    @Column(name = "SECRET_MENU")
    var secretMenu: Boolean,

    @Column(name = "MENU_RATE")
    var menuRate: Int,

    @Column(name = "MENU_ID")
    var menuId: Long,

    @Transient
    var koName: String? = null,

    @Transient
    var enName: String? = null,

) {
    fun update(reviewMenuVo: ReviewMenuVo) {
        this.menuId = reviewMenuVo.menuId
    }
}
