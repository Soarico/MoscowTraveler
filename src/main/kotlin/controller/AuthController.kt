package org.example.controller

import org.example.request.UserRegister
import org.example.response.UserCreateResponse
import org.example.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
class AuthController (
    val userService: UserService,
) {
    @PostMapping("/users")
    fun createUser(@RequestBody userRegister: UserRegister) = userService.add(userRegister)
}
