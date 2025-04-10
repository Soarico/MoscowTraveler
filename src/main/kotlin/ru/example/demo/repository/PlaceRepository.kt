package ru.example.demo.repository

import ru.example.demo.entity.Place
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaceRepository: JpaRepository<Place, Long> {
    fun findByNameContaining(name : String): List<Place>
    fun findByName(name : String) : Place?
}