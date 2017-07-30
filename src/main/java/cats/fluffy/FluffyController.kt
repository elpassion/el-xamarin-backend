package cats.fluffy

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fluffy")
class FluffyController(val fluffyRepo: FluffyRepository) {

    @GetMapping("/add")
    @ResponseBody
    fun addFluffy(@RequestParam name: String): String {
        val fluffy = Fluffy(name = name)
        fluffyRepo.save(fluffy)
        return "SAVED!"
    }

    @GetMapping("/all")
    @ResponseBody
    fun allFluffies() = fluffyRepo.findAll()
}