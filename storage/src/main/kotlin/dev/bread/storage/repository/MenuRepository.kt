package dev.bread.storage.repository

import dev.bread.storage.entity.Menu
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<Menu, Long> {
    fun findByIdIn(menuIds: List<Long>): List<Menu>?
}
