package ru.example.demo.controller

import ru.example.demo.request.UserRegister
import ru.example.demo.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
class AuthController (
    val userService: UserService,
) {
    @PostMapping("/users")
    fun createUser(@RequestBody userRegister: UserRegister) = userService.add(userRegister)
}
