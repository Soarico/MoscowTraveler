package org.example.service


import org.apache.coyote.BadRequestException
import org.example.repository.PlaceRepository
import org.example.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService (
    private val placeRepository: PlaceRepository,
    private val userRepository: UserRepository
) {
    fun addToFavorites(id : Long, sightname : String) {
        val user = userRepository.findById(id)
        if (user == null) throw BadRequestException("Такого пользователя не существует")
        val place = placeRepository.findByName(sightname)
        if (place == null) throw BadRequestException("Такого места не существует")
        user.places.add(place)
    }
}