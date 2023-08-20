package dev.bread.storage.mapper

import dev.bread.domain.Menu
import dev.bread.storage.entity.MenuEntity

fun Menu.toEntity(): MenuEntity {
    return MenuEntity(
        koName = this.koName,
        enName = this.enName
    )
}

fun MenuEntity.toDomain(): Menu {
    return Menu(
        koName = this.koName,
        enName = this.enName
    )
}
