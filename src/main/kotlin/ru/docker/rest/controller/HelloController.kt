package ru.docker.rest.controller

import org.slf4j.LoggerFactory
import org.springframework.jdbc.core.simple.SimpleJdbcCall
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import javax.sql.DataSource

@RestController
@RequestMapping("api")
class HelloController(
        private val dataSource: DataSource
) {
    private var logger = LoggerFactory.getLogger(HelloController::class.java)

    @GetMapping(value = "/hello/{message}")
    fun hello(@PathVariable message: String): String {
        logger.trace("Hello controller message=$message")
        val simpleJdbcCall = SimpleJdbcCall(dataSource).withFunctionName("SET_LOG")
        val id = simpleJdbcCall.executeFunction(BigDecimal::class.java, message)
        logger.debug("Saved log id=$id")
        logger.info("Successfully processed message")
        return "Hello $message!"
    }

}
