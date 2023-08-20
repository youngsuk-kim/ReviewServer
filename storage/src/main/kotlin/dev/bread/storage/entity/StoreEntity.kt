package dev.bread.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "store")
class StoreEntity(

    @Column
    val open: Boolean = true

) : BaseEntity()
