package items

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ItemController(val itemRepo: ItemRepository) {

    @GetMapping("/add")
    @ResponseBody
    fun addFluffy(@RequestParam text: String, @RequestParam description: String): String {
        val fluffy = Item(text = text, description = description)
        itemRepo.save(fluffy)
        return "SAVED!"
    }

    @GetMapping("/delete")
    @ResponseBody
    fun removeFluffy(@RequestParam id: Long): String {
        itemRepo.delete(id)
        return "DELETED"
    }

    @GetMapping("/item")
    @ResponseBody
    fun allFluffies() = itemRepo.findAll()

    @GetMapping("/item")
    @ResponseBody
    fun fluffy(@RequestParam id: Long) = itemRepo.findOne(id)
}