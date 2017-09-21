package items

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class FluffyController(val fluffyRepo: FluffyRepository) {

    @GetMapping("/add")
    @ResponseBody
    fun addFluffy(@RequestParam text: String, @RequestParam description: String): String {
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
    fun allFluffies() = fluffyRepo.findAll()

    @GetMapping("/item")
    @ResponseBody
    fun fluffy(@RequestParam id: Long) = fluffyRepo.findOne(id)
}