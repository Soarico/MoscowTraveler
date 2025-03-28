package ru.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
//@EnableJpaRepositories("org.example.repository")
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}