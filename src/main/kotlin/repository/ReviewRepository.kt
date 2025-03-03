package org.example.repository

import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Long> {
    fun findByPlaceId(placeId: Long): List<Review>
}