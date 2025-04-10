package ru.example.demo.repository

import ru.example.demo.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository: JpaRepository<Review, Long> {
    fun findByPlaceId(placeId: Long): List<Review>
}