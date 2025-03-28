package ru.example.demo.request

import ru.example.demo.entity.User

data class UserRegister (
    val username : String,
    val email : String,
    val password : String
)

fun UserRegister.toEntity() = User(
    email = email,
    password = password,
    username = username
)