package ru.example.demo.controller

import ru.example.demo.service.PlaceService

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import ru.example.demo.entity.SightInfo
import ru.example.demo.service.UserService

@RestController
class PlaceController (
    val placeService: PlaceService,
    val userService: UserService
) {
    @GetMapping("/name")
    fun nameQuery(@RequestParam("sightname") sightname : String) : ResponseEntity<SightInfo> {
        val sightInfo = placeService.findByName(sightname)
        return ResponseEntity(sightInfo, HttpStatus.OK)
    }

    @GetMapping("/photo")
    fun pictureQuery(@RequestParam("file") photo: MultipartFile) : ResponseEntity<SightInfo> {
        placeService.findByPicture(photo)
        TODO()
    }

    @PostMapping("/place")
    fun addToFavorites(@RequestParam("username") username : String, @RequestParam("name") sightname : String) : ResponseEntity<String> {
        userService.addToFavorites(username, sightname)
        return ResponseEntity("The list of favourite places was successfully updated", HttpStatus.OK)
    }
}