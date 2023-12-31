package dev.bread.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "STORE")
class Store(

    @Column
    val open: Boolean = true

) : BaseEntitiy()
