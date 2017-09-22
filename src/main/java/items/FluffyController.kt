package items

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class FluffyController(val fluffyRepo: FluffyRepository) {

    @PostMapping("/add")
    fun addFluffy(@RequestParam text: String, @RequestParam description: String): String {
        val fluffy = Fluffy(text = text, description = description)
        fluffyRepo.save(fluffy)
        return "SAVED!"
    }

    @DeleteMapping("/delete")
    fun removeFluffy(@RequestParam id: String): String {
        fluffyRepo.delete(id.toLong())
        return "DELETED"
    }

    @GetMapping("/items")
    @ResponseBody
    fun allFluffies(): MutableIterable<Fluffy> = fluffyRepo.findAll()
}