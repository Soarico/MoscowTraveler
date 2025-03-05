package org.example.entities

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val username: String,

    @Column(nullable = false)
    val email: String,

    @OneToMany(mappedBy = "user")
    val photos: List<Photo> = mutableListOf(),

    @OneToMany(mappedBy = "user")
    val reviews: List<Review> = mutableListOf()
)