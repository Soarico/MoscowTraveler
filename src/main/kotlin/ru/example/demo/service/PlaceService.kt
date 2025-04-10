package ru.example.demo.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import ru.example.demo.entity.SightInfo

@Service
class PlaceService {
    fun find(photo: MultipartFile) : SightInfo {
        TODO()
    }
}