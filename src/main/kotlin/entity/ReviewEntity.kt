package org.example.entities

import jakarta.persistence.*

@Entity
@Table(name = "reviews")
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