package cats.fluffy

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class FluffyController {

    val fluffyCounter = AtomicLong()

    @RequestMapping("/fluffy")
    fun fluffy() = Fluffy(id = fluffyCounter.incrementAndGet(), name = "Fluffy")
}