package ru.example.demo.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import ru.example.demo.entity.Photo
import ru.example.demo.entity.SightInfo
import ru.example.demo.exception.BadRequestException
import ru.example.demo.repository.PhotoRepository
import ru.example.demo.repository.PlaceRepository

@Service
class PlaceService (
    val placeRepository: PlaceRepository,
    val photoRepository: PhotoRepository
) {

    fun getImageById(id: Long): Photo {
        return photoRepository.findById(id).orElseThrow {
            NoSuchElementException("Image not found with id: $id")
        }
    }

    fun findByPicture(photo: MultipartFile) : SightInfo {
        TODO()
    }

    fun findByName(sightname: String) : SightInfo {
        val tryPlace = placeRepository.findByName(sightname)
        if (tryPlace == null) throw BadRequestException("Этого места пока нет в нашей базе")
        val place = placeRepository.findByName(sightname)!!
        val photos = photoRepository.findByPlaceId(place.id);
        val sightInfo = SightInfo(photos[0].imageUrl, sightname, place.description, place.latitude, place.longitude)
        return sightInfo
    }
}