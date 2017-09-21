package items

import org.springframework.data.repository.CrudRepository

interface FluffyRepository : CrudRepository<Fluffy, Long>