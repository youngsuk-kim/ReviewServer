package dev.bread.storage.repository

import dev.bread.domain.Menu
import dev.bread.domain.MenuRepository
import dev.bread.storage.mapper.toDomain
import org.springframework.stereotype.Repository

@Repository
class MenuRepositoryImpl(
    private val jpaMenuRepository: JpaMenuRepository
) : MenuRepository {
    override fun findById(menuId: Long): Menu {
        val menuEntity = jpaMenuRepository.findById(menuId)
            .orElseThrow { throw NoSuchElementException("Menu not found error occurred.") }

        return Menu(koName = menuEntity.koName, enName = menuEntity.enName)
    }

    override fun findByIdIn(menuIds: List<Long>): List<Menu>? {
        val menus = jpaMenuRepository.findByIdIn(menuIds)
            ?.map { it.toDomain() }

        return menus?.map { Menu(koName = it.koName, enName = it.enName) }
    }
}
