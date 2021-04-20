package ru.docker.rest.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.sql.DataSource

@RestController
@RequestMapping("api")
class HelloController(
        private val dataSource: DataSource
) {
    private var logger = LoggerFactory.getLogger(HelloController::class.java)

    @GetMapping(value = ["/hello/{message}"])
    fun hello(@PathVariable message: String): String {
        logger.trace("Hello controller message=$message")
        val messageId = UUID.randomUUID().toString()
        dataSource.connection.use {
            val statement = it.prepareStatement("insert into logs(id, value , date) values(?,?,?)")
            statement.setString(1, messageId)
            statement.setString(2, message)
            statement.setDate(3, java.sql.Date(Date().time))
            statement.execute()
        }
        logger.debug("Saved log id=$messageId")
        logger.info("Successfully processed message")
        return "Hello $message!"
    }

}
