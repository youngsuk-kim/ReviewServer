package dev.bread.storage.repository

import dev.bread.storage.entity.OrderMenu
import org.springframework.data.jpa.repository.JpaRepository

interface OrderMenuRepository : JpaRepository<OrderMenu, Long> {
    fun findByIdIn(menuIds: List<Long>): List<OrderMenu>?
}
