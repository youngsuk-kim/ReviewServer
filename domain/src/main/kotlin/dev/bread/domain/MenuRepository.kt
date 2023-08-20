package dev.bread.domain

interface MenuRepository {
    fun findById(menuId: Long): Menu
    fun findByIdIn(menuIds: List<Long>): List<Menu>?
}
