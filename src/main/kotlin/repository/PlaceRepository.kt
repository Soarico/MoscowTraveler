package org.example.repository

import org.example.entities.Place
import org.springframework.data.jpa.repository.JpaRepository

interface PlaceRepository: JpaRepository<Place, Long> {
    fun findByNameContaining(name : String): List<Place>
    fun findByName(name : String) : Place?
}