package org.example.response

data class UserCreateResponse (
    val id : Long,
    val username : String,
    val token : String
)