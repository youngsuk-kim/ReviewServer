package dev.bread.storage.repository

import dev.bread.storage.entity.MenuEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaMenuRepository : JpaRepository<MenuEntity, Long> {
    fun findByIdIn(menuIds: List<Long>): List<MenuEntity>?
}
