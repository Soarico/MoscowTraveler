package ru.example.demo.client

import ru.example.demo.request.UserRegister
import ru.example.demo.dto.UserCreateResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@FeignClient(name = "userClient", url = "http://localhost:8080/")
interface UserClient {

    @PostMapping(value = ["/users"])
    fun registerUser(@RequestBody user : UserRegister): ResponseEntity<UserCreateResponse>
}