//package ru.example.demo.controller
//
//
//import ru.example.demo.service.UserService
//import org.springframework.http.HttpStatus
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.*
//import ru.example.demo.service.MessageService
//
//@RestController
//class InteractionController (
//    val userService: UserService,
//    val messageService: MessageService,
//) {
//    @PostMapping("/friends")
//    fun makeFriends(@RequestParam("tg") tg : String) : ResponseEntity<String> {
//        userService.addFriend(tg)
//        return ResponseEntity("The list of friends was successfully updated", HttpStatus.OK)
//    }
//
//    @PostMapping("/users")
//    fun share(@RequestParam("from") from : String, @RequestParam("from") to : String, @RequestParam("sight") sight : String) : ResponseEntity<String> {
//        messageService.shareWithFriend(from, to, sight)
//        return ResponseEntity("Message was sent successfully", HttpStatus.OK)
//    }
//}