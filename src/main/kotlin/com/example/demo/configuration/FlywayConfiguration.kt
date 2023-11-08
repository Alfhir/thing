import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

// Flyway 10.0.0 includes some significant changes, making it incompatible with Spring Boot's 3.1.5 auto-configuration.
// To handle this situation, auto-configuration was disabled, and a custom Flyway bean was manually defined to control the database migrations.
// When the custom Flyway bean was introduced, Spring Boot failed to auto-wire the DataSource bean (required by Flyway), despite the database connection configuration being defined.
// Subsequently, a manually defined DataSource bean was added to ensure the Flyway bean receives the necessary dependencies while retaining control over the migration handling process.
@Configuration
class FlywayConfiguration {

    @Value("\${spring.datasource.url}")
    private lateinit var url: String

    @Value("\${spring.datasource.username}")
    private lateinit var username: String

    @Value("\${spring.datasource.password}")
    private lateinit var password: String

    @Bean
    @Primary
    fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("org.postgresql.Driver")
        dataSource.url = url
        dataSource.username = username
        dataSource.password = password
        return dataSource
    }

    @Bean(initMethod = "migrate")
    fun flyway(dataSource: DataSource): Flyway {
        return Flyway.configure()
            .dataSource(dataSource)
            .locations("classpath:db/migration")
            .load()
    }
}