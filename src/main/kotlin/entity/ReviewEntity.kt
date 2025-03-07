package org.example.entities

import jakarta.persistence.*

@Entity
//idx_review_user ускоряет поиск отзывов конкретного пользователя .
//idx_review_place ускоряет загрузку всех отзывов по определённому месту .
@Table(
    name = "reviews",
    indexes = [
        Index(name = "idx_review_user", columnList = "user_id"),
        Index(name = "idx_review_place", columnList = "place_id")
    ]
)
data class Review(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val rating: Int,

    @Column(nullable = false)
    val comment: String,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    val place: Place
)