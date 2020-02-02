package ru.docker.rest.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource


@Configuration
@ConfigurationProperties(prefix = "app.datasource")
class JdbcConfig : HikariConfig() {
    @Bean
    fun dataSource(): DataSource {
        return HikariDataSource(this)
    }
}