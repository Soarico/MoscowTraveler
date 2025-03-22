package demo.application.service

import demo.application.entity.SightInfo
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class PlaceService {
    fun find(photo: MultipartFile) : SightInfo {
        TODO()
    }
}