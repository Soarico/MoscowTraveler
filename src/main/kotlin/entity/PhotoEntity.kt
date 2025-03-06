package org.example.entities

import jakarta.persistence.*

@Entity
@Table(name = "photos")
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
