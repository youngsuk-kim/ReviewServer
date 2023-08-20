package dev.bread.storage.repository

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import dev.bread.domain.ReviewMenu
import dev.bread.domain.repository.MenuCustomRepository
import dev.bread.storage.entity.QMenuEntity.menuEntity
import dev.bread.storage.entity.QReviewEntity.reviewEntity
import dev.bread.storage.entity.QReviewMenuVo.reviewMenuVo
import org.springframework.stereotype.Repository

@Repository
class MenuRepositoryCustomImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : MenuCustomRepository {

    /*
    유저가 추천한 메뉴를 찾는다
     */
    override fun findMenuReview(memberId: Long): MutableList<ReviewMenu>? {
        return jpaQueryFactory
            .select(
                Projections.fields(
                    ReviewMenu::class.java,
                    reviewMenuVo.recommend,
                    reviewMenuVo.secretMenu,
                    menuEntity.koName,
                    menuEntity.enName,
                    reviewMenuVo.menuRate,
                    reviewMenuVo.menuId
                )
            )
            .from(menuEntity)
            .join(menuEntity).on(reviewMenuVo.menuId.eq(menuEntity.id))
            .where(reviewEntity.memberId.eq(memberId))
            .fetch()
    }
}
