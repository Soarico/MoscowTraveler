package org.example.service


import org.apache.coyote.BadRequestException
import org.example.dto.User
import org.example.repository.PlaceRepository
import org.example.repository.UserRepository
import org.example.response.UserCreateResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    private val placeRepository: PlaceRepository,
    private val userRepository: UserRepository
) {
    @Transactional
    fun addToFavorites(username : String, sightname : String) {
        val user = userRepository.findByUsername(username)
        if (user == null) throw BadRequestException("Такого пользователя не существует")
        val place = placeRepository.findByName(sightname)
        if (place == null) throw BadRequestException("Такого места не существует")
        user.places.add(place.id)
    }
    
    fun add(user : User) : User {
        TODO()
    }

    fun addFriend(tg : String) {
        TODO()
    }
}