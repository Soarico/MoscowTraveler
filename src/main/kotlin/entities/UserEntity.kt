package org.example.entities

import jakarta.persistence.*

@Entity
//idx_username и idx_email нужны, так как поиск по имени пользователя и email должен быть быстрым.
//Уникальность важна, чтобы не было дублирования пользователей.
@Table(
    name = "users",
    indexes = [
        Index(name = "idx_username", columnList = "username", unique = true),
        Index(name = "idx_email", columnList = "email", unique = true)
    ]
)
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