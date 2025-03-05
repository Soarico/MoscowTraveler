package org.example.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class InfoController (
    val infoService: InfoService,
) {
    @GetMapping("/photo")
    fun pictureQuery(@RequestParam("file") photo: MultipartFile) : ResponseEntity<SightInfo> {
        return infoService.find(photo)
    }
}