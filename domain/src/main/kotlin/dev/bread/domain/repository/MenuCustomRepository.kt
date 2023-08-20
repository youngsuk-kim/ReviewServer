package dev.bread.domain.repository

import dev.bread.domain.ReviewMenu

interface MenuCustomRepository {
    fun findMenuReview(memberId: Long): MutableList<ReviewMenu>?
}
