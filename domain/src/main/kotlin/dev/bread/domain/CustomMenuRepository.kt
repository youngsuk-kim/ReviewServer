package dev.bread.domain

interface CustomMenuRepository {
    fun findRecommend(memberId: Long): MutableList<ReviewMenuData>?
}
