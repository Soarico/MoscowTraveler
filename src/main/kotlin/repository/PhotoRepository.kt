package org.example.repository

import demo.application.dto.Photo
import org.springframework.data.jpa.repository.JpaRepository

interface PhotoRepository: JpaRepository<Photo, Long> {
    fun findByUserId(userId :Long): List<Photo>
    fun findByPlaceId(placeId: Long): List<Photo>
}