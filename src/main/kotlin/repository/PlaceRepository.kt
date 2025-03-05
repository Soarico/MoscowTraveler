package org.example.repository

import org.springframework.data.jpa.repository.JpaRepository

interface PlaceRepository: JpaRepository<Place, Long> {
    fun findByNameContaining(name :String): List<Place>
}