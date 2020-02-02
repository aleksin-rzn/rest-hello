package ru.docker.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DockerRestApplication

fun main(args: Array<String>) {
    runApplication<DockerRestApplication>(*args)
}
