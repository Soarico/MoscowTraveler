package ru.example.demo.repository

import ru.example.demo.entity.Photo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhotoRepository: JpaRepository<Photo, Long> {
    fun findByUserId(userId :Long): List<Photo>
    fun findByPlaceId(placeId: Long): List<Photo>
}