package dev.bread.storage.repository

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import dev.bread.storage.data.ReviewMenuResult
import dev.bread.storage.entity.QMenu.menu
import dev.bread.storage.entity.QReview.review
import dev.bread.storage.entity.QReviewMenu.reviewMenu
import org.springframework.stereotype.Repository

@Repository
class MenuRepositoryCustomImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : MenuRepositoryCustom {
    override fun findRecommend(memberId: Long): MutableList<ReviewMenuResult>? {
        return jpaQueryFactory
            .select(Projections.fields(ReviewMenuResult::class.java, menu.koName, menu.enName, reviewMenu.secretMenu, reviewMenu.menuRate, reviewMenu.recommend))
            .from(menu)
            .join(menu).on(reviewMenu.menuId.eq(menu.id))
            .where(review.memberId.eq(memberId))
            .fetch()
    }
}
