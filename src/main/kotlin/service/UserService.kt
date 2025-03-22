package org.example.service


import ru.school57.todolist.exception.BadRequestException
import org.example.repository.PlaceRepository
import org.example.repository.UserRepository
import org.example.request.UserRegister
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

    @Transactional
    fun add(request : UserRegister) : String {
        val user = userRepository.findByEmail(request.email)
        if (user != null)
            throw BadRequestException("Пользователь уже зарегистрирован")
        userRepository.save(
            org.example.entities.User(
                email = request.email,
                password = request.password,
                username = request.username
            )
        )
        return "Пользователь успешно зарегистрирован"
    }

    fun addFriend(tg : String) {
        TODO()
    }
}