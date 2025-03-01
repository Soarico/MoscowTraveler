package org.example.controller

import org.example.dto.User
import org.example.response.UserCreateResponse
import org.example.response.UserFriendsResponse
import org.example.response.UserRateResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.awt.print.Pageable

@RestController
class TravController (
    val userService: UserService,
    val messageService: MessageService,
    val infoService: InfoService,
) {
    @PostMapping("/users")
    fun createUser(@RequestBody user : User) : UserCreateResponse {
        return userService.add(user)
    }

    @GetMapping("/photo")
    fun pictureQuery(@RequestParam("file") photo: MultipartFile) : ResponseEntity<SightInfo> {
        return infoService.find(photo)
    }

    @PostMapping("/users")
    fun makeFriens(@RequestParam("tg") tg : String) : ResponseEntity<String> {
        userService.addFriend(tg)
        return ResponseEntity("The list of friends was successfully updated", HttpStatus.OK)
    }

    @PostMapping("/users/rate")
    fun rate(@RequestParam("sight") sight : String, @RequestParam("rate") rate : Boolean) : ResponseEntity<String> {
        infoService.updateRating(sight, rate)
        return ResponseEntity("The rating was successfully updated", HttpStatus.OK)
    }

    @GetMapping("/rating")
    fun getRating() : ResponseEntity<Rating> {
        return infoService.getRating()
    }

    @PostMapping("/users")
    fun share(@RequestParam("tg") user : String, @RequestParam("sight") sight : String) : ResponseEntity<String> {
        messageService.shareWithFriend()
        return ResponseEntity("Message sent successfully", HttpStatus.OK)
    }
}
