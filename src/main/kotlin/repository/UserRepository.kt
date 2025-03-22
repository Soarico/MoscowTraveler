package org.example.repository

import org.example.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username : String): User?
    fun findByEmail(email : String) : User?
}