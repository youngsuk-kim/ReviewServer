package dev.bread.application.implementation

import dev.bread.application.MenuResult
import dev.bread.domain.CustomMenuRepository
import dev.bread.domain.Menu
import dev.bread.domain.MenuRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional(readOnly = true)
class MenuReader(
    private val menuRepository: MenuRepository,
    private val customMenuRepository: CustomMenuRepository
) {
    fun read(menuId: Long): Menu {
        return menuRepository.findById(menuId)
    }

    fun read(menuIds: List<Long>): List<Menu>? {
        return menuRepository.findByIdIn(menuIds)
    }

    fun findRecommendMenuByMemberId(memberId: Long): List<MenuResult>? {
        return customMenuRepository.findRecommend(memberId)
            ?.map { MenuResult(it.koName, it.enName, it.recommend) }
    }
}
