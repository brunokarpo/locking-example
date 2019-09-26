package nom.brunokarpo.lockingexample.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "person")
data class Person(
        @Id
        var id: UUID? = null,
        var name: String? = "",
        var age: Int? = 0
)