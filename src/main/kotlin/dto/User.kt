package org.example.dto

import demo.application.dto.Place

data class User (
    val id : Long,
    val token: String,
    val username : String,
    val email : String,
    val password : String,
    var places : MutableList<Place>
)