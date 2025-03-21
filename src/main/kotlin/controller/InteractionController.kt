package org.example.controller

import org.example.service.MessageService
import org.example.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
class InteractionController (
    val userService: UserService,
    val messageService: MessageService,
) {
    @PostMapping("/users")
    fun makeFriens(@RequestParam("tg") tg : String) : ResponseEntity<String> {
        userService.addFriend(tg)
        return ResponseEntity("The list of friends was successfully updated", HttpStatus.OK)
    }

    @PostMapping("/users")
    fun share(@RequestParam("from") from : String, @RequestParam("from") to : String, @RequestParam("sight") sight : String) : ResponseEntity<String> {
        messageService.shareWithFriend(from, to, sight)
        return ResponseEntity("Message was sent successfully", HttpStatus.OK)
    }
}