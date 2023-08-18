package dev.bread.storage.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "REVIEW_LIKE")
class ReviewLike() : BaseEntity()
