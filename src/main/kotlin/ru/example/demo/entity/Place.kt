package ru.example.demo.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Size

@Entity
//idx_place_name ускоряет поиск по названию.
//idx_place_location ускоряет географический поиск (например, "найти ближайшие места"),
// так как часто будем фильтровать по latitude и longitude.
@Table(
    name = "places",
    indexes = [
        Index(name = "idx_place_name", columnList = "name"),
        Index(name = "idx_place_location", columnList = "latitude, longitude")
    ]
)
data class Place(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @field:Size(max = 1000)
    @Column(nullable = false, length = 1000)
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