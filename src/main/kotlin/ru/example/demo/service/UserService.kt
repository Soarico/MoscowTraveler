package ru.example.demo.service


import ru.example.demo.exception.BadRequestException
import ru.example.demo.repository.PlaceRepository
import ru.example.demo.repository.UserRepository
import ru.example.demo.request.UserRegister
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.example.demo.entity.User

@Service
class UserService (
    private val placeRepository: PlaceRepository,
    private val userRepository: UserRepository
) {

    @Transactional
    fun add(request : UserRegister) : String {
        val user = userRepository.findByEmail(request.email)
        if (user != null)
            throw BadRequestException("Пользователь уже зарегистрирован")
        userRepository.save(
            User(
                email = request.email,
                password = request.password,
                username = request.username
            )
        )
        return "Пользователь успешно зарегистрирован"
    }

    @Transactional
    fun addToFavorites(username : String, sightname : String) {
        val user = userRepository.findByUsername(username)
        if (user == null) throw BadRequestException("Такого пользователя не существует")
        val place = placeRepository.findByName(sightname)
        if (place == null) throw BadRequestException("Такого места не существует")
        user.places.add(place.id)
    }

    fun addFriend(tg : String) {
        TODO()
    }
}
