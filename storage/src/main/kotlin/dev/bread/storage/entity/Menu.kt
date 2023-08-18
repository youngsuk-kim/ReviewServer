package dev.bread.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "MENU")
class Menu(

    @Column(name = "NAME_KO", nullable = false)
    var koName: String,

    @Column(name = "NAME_EN")
    var enName: String

) : BaseEntity()