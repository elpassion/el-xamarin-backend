package cats.fluffy

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class FluffyApp

fun main(args: Array<String>) {
    SpringApplication.run(FluffyApp::class.java, *args)
}
