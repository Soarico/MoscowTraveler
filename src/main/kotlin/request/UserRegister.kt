package org.example.request

import org.example.entities.User

class UserRegister (
    val username : String,
    val email : String,
    val password : String
)

fun UserRegister.toEntity() = User(
    email = email,
    password = password,
    username = username
)