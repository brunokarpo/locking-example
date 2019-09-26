package nom.brunokarpo.lockingexample.services

import nom.brunokarpo.lockingexample.model.Person
import nom.brunokarpo.lockingexample.repository.PersonRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService(
        private val repository: PersonRepository
) {

    fun create(person: Person): Person {
        person.id = UUID.randomUUID()
        return repository.save(person)
    }

}