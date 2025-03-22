package org.example.entities

import jakarta.persistence.*

@Entity
//idx_photo_user ускоряет поиск всех фото конкретного пользователя .
//idx_photo_place ускоряет поиск всех фото конкретного места .
@Table(
    name = "photos",
    indexes = [
        Index(name = "idx_photo_user", columnList = "user_id"),
        Index(name = "idx_photo_place", columnList = "place_id")
    ]
)
data class Photo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val imageUrl: String,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    val place: Place
)
