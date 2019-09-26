package nom.brunokarpo.lockingexample.repository

import nom.brunokarpo.lockingexample.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonRepository: JpaRepository<Person, UUID>