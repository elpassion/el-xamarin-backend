package items

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class FluffyController(val fluffyRepo: FluffyRepository) {

    @PostMapping(value = "items")
    fun addFluffy(@RequestParam text: String, description: String): String {
        val fluffy = Fluffy(text = text, description = description)
        fluffyRepo.save(fluffy)
        return "SAVED!"
    }

    @GetMapping("/delete")
    @ResponseBody
    fun removeFluffy(@RequestParam id: Long): String {
        fluffyRepo.delete(id)
        return "DELETED"
    }

    @GetMapping("/items")
    @ResponseBody
    fun allFluffies(): MutableIterable<Fluffy> = fluffyRepo.findAll()
}