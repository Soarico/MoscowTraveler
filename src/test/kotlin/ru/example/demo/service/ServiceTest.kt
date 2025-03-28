package ru.example.demo.service

import ru.example.demo.DemoApplication
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldNotBe
import ru.example.demo.repository.UserRepository
import ru.example.demo.request.UserRegister
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.example.demo.entity.User
import ru.example.demo.exception.BadRequestException
import ru.example.demo.repository.PlaceRepository

@SpringBootTest(classes = [DemoApplication::class])
@ActiveProfiles("test")
class ServiceTest {
    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var placeRepository: PlaceRepository

    @Autowired
    lateinit var userService: UserService


    @Test
    fun `когда пытается зарегистирироваться пользователь, которого нет в базе`() {
        val newUser = UserRegister(
            username = "Петя",
            email = "petya@yandex.com",
            password = "12345"
        )

        userService.add(newUser)

        val user = userRepository.findByUsername(newUser.username)

        user shouldNotBe null
    }

    @Test
    fun `когда пытается зарегистирироваться пользователь, который есть в базе`() {
        val newUser = UserRegister(
            username = "Петя",
            email = "petya@yandex.com",
            password = "12345"
        )
        userRepository.save(User(
            email = newUser.email,
            password = newUser.password,
            username = newUser.username
        ))
        shouldThrow<BadRequestException> {
            userService.add(newUser)
        }
    }
}