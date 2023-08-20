package dev.bread.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "MEMBER")
class MemberEntity(

    @Column(name = "NAME", nullable = false)
    var name: String

) : BaseEntity()
