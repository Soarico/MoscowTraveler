package demo.application.entity
import jakarta.persistence.*
import org.example.entities.Photo

@Entity
data class SightInfo (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val sightName : String,

    @Column(nullable = true)
    val placeIntRating : Int,

    @Column(nullable = true)
    val averageRate : Double,

    @Column(nullable = false)
    val description: String,
)