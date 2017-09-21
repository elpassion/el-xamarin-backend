package items

import org.springframework.data.repository.CrudRepository

interface ItemRepository : CrudRepository<Item, Long>