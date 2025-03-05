package org.example.controller

import org.example.dto.User
import org.example.response.UserCreateResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class AuthController (
    val userService: UserService,
) {
    @PostMapping("/users")
    fun createUser(@RequestBody user : User) : UserCreateResponse {
        return userService.add(user)
    }
}
