package ru.example.demo.unit

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import ru.example.demo.repository.UserRepository
import ru.example.demo.request.UserRegister
import ru.example.demo.request.toEntity
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import ru.example.demo.exception.BadRequestException
import io.kotest.matchers.shouldBe
import ru.example.demo.entity.User
import ru.example.demo.repository.PlaceRepository
import ru.example.demo.service.UserService

class UserServiceTest {
    private val userRepository = mockk<UserRepository>()
    private val placeRepository = mockk<PlaceRepository>()

    private val userService = UserService(placeRepository, userRepository)

    @Test
    fun `когда пытается зарегистирироваться пользователь, которого нет в базе`() {
        val newUser = UserRegister(
            username = "Петя",
            email = "petya@yandex.com",
            password = "12345"
        )

        every { userRepository.findByEmail(newUser.email)} answers { null }
        every { userRepository.save(
            User(
                email = newUser.email,
                password = newUser.password,
                username = newUser.username
            )
        )} answers { User(
            email = newUser.email,
            password = newUser.password,
            username = newUser.username
        ) }

        userService.add(newUser)

        verify(exactly = 1){ userRepository.save(newUser.toEntity()) }
    }

    @Test
    fun `когда пытается зарегистирироваться пользователь, который есть в базе`() {
        val newUser = UserRegister(
            username = "Петя",
            email = "petya@yandex.com",
            password = "12345"
        )

        every { userRepository.findByEmail(newUser.email)} answers { User(
            email = newUser.email,
            password = newUser.password,
            username = newUser.username
        ) }
        every { userRepository.save(
            User(
                email = newUser.email,
                password = newUser.password,
                username = newUser.username
            )
        )} answers { User(
            email = newUser.email,
            password = newUser.password,
            username = newUser.username
        ) }

        val exception = assertThrows(BadRequestException::class.java) {
            userService.add(newUser)
        }

        exception.message shouldBe "Пользователь уже зарегистрирован"
    }

    @Test
    fun `когда приходит запрос на добавление места в избранные от пользователя, которого не существует`() {
        val username = "Петя"
        val sightname = "Красная площадь"
        every { userRepository.findByUsername(username)} answers { null }

        val exception = assertThrows(BadRequestException::class.java) {
            userService.addToFavorites(username, sightname)
        }

        exception.message shouldBe "Такого пользователя не существует"
    }

    @Test
    fun `когда приходит запрос на добавление места, котрое не существует, в избранные`() {
        val username = "Петя"
        val sightname = "Красная площадь"
        every { userRepository.findByUsername(username)} answers { User(
            email = "petya@yandex.com",
            password = "12345",
            username = username
        ) }

        every { placeRepository.findByName(sightname)} answers { null }
        val exception = assertThrows(BadRequestException::class.java) {
            userService.addToFavorites(username, sightname)
        }

        exception.message shouldBe "Такого места не существует"
    }
}