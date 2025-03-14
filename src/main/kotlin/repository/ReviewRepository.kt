package org.example.repository

import org.example.entities.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Long> {
    fun findByPlaceId(placeId: Long): List<Review>
}