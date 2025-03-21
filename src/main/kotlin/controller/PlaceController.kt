package org.example.controller

import demo.application.service.PlaceService
import org.example.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import sightInfo

@RestController
class PlaceController (
    val placeService: PlaceService,
    val userService: UserService
) {
    @GetMapping("/photo")
    fun pictureQuery(@RequestParam("file") photo: MultipartFile) : ResponseEntity<sightInfo> {
        placeService.find(photo)
        TODO()
    }

    @PostMapping("/place")
    fun addToFavorites(@RequestParam("username") username : String, @RequestParam("name") sightname : String) : ResponseEntity<String> {
        userService.addToFavorites(username, sightname)
        return ResponseEntity("The list of favourite places was successfully updated", HttpStatus.OK)
    }
}