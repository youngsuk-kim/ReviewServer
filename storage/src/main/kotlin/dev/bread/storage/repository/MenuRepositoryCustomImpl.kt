package dev.bread.storage.repository

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import dev.bread.domain.CustomMenuRepository
import dev.bread.domain.ReviewMenuData
import dev.bread.storage.entity.QMenuEntity.menuEntity
import dev.bread.storage.entity.QReviewEntity.reviewEntity
import dev.bread.storage.entity.QReviewMenuVo.reviewMenuVo
import org.springframework.stereotype.Repository

@Repository
class MenuRepositoryCustomImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomMenuRepository {
    override fun findRecommend(memberId: Long): MutableList<ReviewMenuData>? {
        return jpaQueryFactory
            .select(
                Projections.fields(
                    ReviewMenuData::class.java,
                    menuEntity.koName,
                    menuEntity.enName,
                    reviewMenuVo.secretMenu,
                    reviewMenuVo.menuRate,
                    reviewMenuVo.recommend
                )
            )
            .from(menuEntity)
            .join(menuEntity).on(reviewMenuVo.menuId.eq(menuEntity.id))
            .where(reviewEntity.memberId.eq(memberId))
            .fetch()
    }
}
