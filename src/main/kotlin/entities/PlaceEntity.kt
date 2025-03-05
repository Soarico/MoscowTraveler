package org.example.entities

import jakarta.persistence.*

@Entity
@Table(name = "places")
data class Place(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val description: String,

    @Column(nullable = false)
    val latitude: Double,

    @Column(nullable = false)
    val longitude: Double,

    @OneToMany(mappedBy = "place")
    val photos: List<Photo> = mutableListOf(),

    @OneToMany(mappedBy = "place")
    val reviews: List<Review> = mutableListOf()
)