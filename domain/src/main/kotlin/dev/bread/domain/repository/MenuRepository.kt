package dev.bread.domain.repository

import dev.bread.domain.Menu

interface MenuRepository {
    fun findById(menuId: Long): Menu?
    fun findByIdIn(menuIds: List<Long>): List<Menu>?
}
