package dev.bread.storage.entity

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    val id: Long? = null

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    val createdAt: LocalDateTime? = null

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    var updatedAt: LocalDateTime? = null
        protected set
}
