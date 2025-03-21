package org.example.response

data class UserCreateResponse (
    var id : Long,
    var username : String,
    var token : String
)