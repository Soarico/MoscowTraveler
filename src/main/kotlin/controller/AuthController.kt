package org.example.controller

import org.example.dto.User
import org.example.response.UserCreateResponse
import org.springframework.web.bind.annotation.*

@RestController
class AuthController (
    val userService: UserService,
) {
    @PostMapping("/users")
    fun createUser(@RequestBody user : User) : UserCreateResponse {
        return userService.add(user)
    }
}
