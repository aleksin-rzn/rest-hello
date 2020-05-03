package ru.docker.rest.dockerrest

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.util.UUID

@RestController
@RequestMapping("api")
class HelloResource {
    private var logger = LoggerFactory.getLogger(HelloResource::class.java)

    @GetMapping(value = "/hello/{message}")
    fun hello(@PathVariable message: String): String{
        logger.info("GET api/hello/$message")
        return "It's really cool build,  $message! Your guid: ${UUID.randomUUID().toString()}"
    }
}
