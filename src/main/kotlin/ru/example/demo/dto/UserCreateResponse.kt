package ru.example.demo.dto

data class UserCreateResponse (
    var id : Long,
    var username : String,
    var token : String
)