package org.example.controller

import org.example.service.InfoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RateController (
    val infoService: InfoService,
) {
    @PostMapping("/users/rate")
    fun rate(@RequestParam("sight") sight : String, @RequestParam("rate") rate : Boolean) : ResponseEntity<String> {
        infoService.updateRating(sight, rate)
        return ResponseEntity("The rating was successfully updated", HttpStatus.OK)
    }

//   @GetMapping("/rating")
//    fun getRating() : ResponseEntity<Rating> {
//        infoService.getRating()
//    }
}