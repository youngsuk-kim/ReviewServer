package dev.bread.storage.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "REVIEW_HISTORY")
class ReviewHistory() : BaseEntity()

@Entity
@Table(name = "REVIEW_MENU_HISTORY")
class ReviewMenuHistory() : BaseEntity()

@Entity
@Table(name = "REVIEW_IMAGE_HISTORY")
class ReviewImageHistory() : BaseEntity()
