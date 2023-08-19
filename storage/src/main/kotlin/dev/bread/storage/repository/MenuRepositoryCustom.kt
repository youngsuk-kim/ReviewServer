package dev.bread.storage.repository

import com.querydsl.core.Tuple
import dev.bread.storage.data.ReviewMenuResult
import dev.bread.storage.entity.Menu

interface MenuRepositoryCustom {
    fun findRecommend(memberId: Long): MutableList<ReviewMenuResult>?
}