package demo.application.service

import demo.application.dto.SightInfo
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class PlaceService {
    fun find(photo: MultipartFile) : ResponseEntity<SightInfo> {
        //TODO()
    }
}