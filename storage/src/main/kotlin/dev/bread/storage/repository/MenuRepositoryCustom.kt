package dev.bread.storage.repository

import dev.bread.storage.data.ReviewMenuData

interface MenuRepositoryCustom {
    fun findRecommend(memberId: Long): MutableList<ReviewMenuData>?
}
