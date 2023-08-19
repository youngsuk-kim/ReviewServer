package dev.bread.storage.repository

import dev.bread.storage.data.ReviewMenuResult

interface MenuRepositoryCustom {
    fun findRecommend(memberId: Long): MutableList<ReviewMenuResult>?
}
