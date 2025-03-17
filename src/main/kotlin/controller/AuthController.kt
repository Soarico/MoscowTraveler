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
        var userCreateResponse : UserCreateResponse
        val user = userService.add(user)
        userCreateResponse.id = user.id
        userCreateResponse.username = user.username
        userCreateResponse.token = user.token
    }
}
