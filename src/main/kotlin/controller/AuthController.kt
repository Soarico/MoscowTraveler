package org.example.controller

import org.example.dto.User
import org.example.response.UserCreateResponse
import org.example.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
class AuthController (
    val userService: UserService,
) {
    @PostMapping("/users")
    fun createUser(@RequestBody user : User) : UserCreateResponse {
        val newUser = userService.add(user)
        return UserCreateResponse (
            id = newUser.id,
            username = user.username,
            token = user.token
        )
    }
}
