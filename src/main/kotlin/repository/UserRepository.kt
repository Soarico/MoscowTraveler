package org.example.repository

import org.example.dto.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username : String): User?
    fun findById(id : Long): User?
}