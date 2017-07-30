package cats.fluffy

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Fluffy(
        val name: String,

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1)
